package org.jhipster.mdl.interpreter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

import org.jhipster.mdl.domain.Answer;
import org.jhipster.mdl.domain.CurrentStep;
import org.jhipster.mdl.domain.MdlUser;
import org.jhipster.mdl.domain.Role;
import org.jhipster.mdl.domain.WorkflowInstance;
import org.jhipster.mdl.domain.WorkflowInstanceState;
import org.jhipster.mdl.repository.AnswerRepository;
import org.jhipster.mdl.repository.CurrentStepRepository;
import org.jhipster.mdl.repository.RoleRepository;
import org.jhipster.mdl.repository.WorkflowInstanceStateRepository;
import org.jhipster.mdl.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.xtext.metadoodle.interpreter.Implementation.InterpreterV2;
import org.xtext.metadoodle.interpreter.Interface.Interpreter;
import org.xtext.metadoodle.interpreter.Interface.MailReminder;
import org.xtext.metadoodle.interpreter.Interface.StepDTO;
import org.xtext.metadoodle.interpreter.Interface.StepDTOFactory;

@Component
public class InterpreterInterface {
	private static final Logger LOG = LoggerFactory.getLogger(InterpreterInterface.class);

	private static final Interpreter INTERPRETER = new InterpreterV2();

	private final CurrentStepRepository currentStepRepository;

	private final AnswerRepository answerRepository;

	private final RoleRepository roleRepository;

	private final MailService mailService;

	private final WorkflowInstanceStateRepository workflowInstanceStateRepository;

	public InterpreterInterface(CurrentStepRepository currentStepRepository, AnswerRepository answerRepository,
			WorkflowInstanceStateRepository workflowInstanceStateRepository, RoleRepository roleRepository,
			MailService mailService) {
		this.currentStepRepository = currentStepRepository;
		this.answerRepository = answerRepository;
		this.workflowInstanceStateRepository = workflowInstanceStateRepository;
		this.roleRepository = roleRepository;
		this.mailService = mailService;
	}

	private Optional<String> getRole(WorkflowInstance workflowInstance, MdlUser mdlUser) {

		for (Role role : roleRepository.findAll()) {
			if (role.getWorkflowInstance().equals(workflowInstance) && role.getUser().equals(mdlUser) && role.getRole() != null) {
				return Optional.of(role.getRole());
			}
		}

		return Optional.empty();
	}

	private List<Answer> getAnswers(WorkflowInstance workflowInstance, MdlUser mdlUser, String stepID) {
		return answerRepository.findAll().parallelStream().filter(a -> a.getWorkflowInstance().equals(workflowInstance)
				&& a.getUser().equals(mdlUser) && a.getStepIdent().equals(stepID)).collect(Collectors.toList());
	}

	private CurrentStep createNewCurrentStep(String stepIdent, WorkflowInstanceState workflowInstanceState) {
		CurrentStep newCurrentStep = new CurrentStep();
		newCurrentStep.setNumberOfAnswer(0);
		newCurrentStep.setStepIdent(stepIdent);

		newCurrentStep = currentStepRepository.save(newCurrentStep);

		workflowInstanceState.addSteps(newCurrentStep);
		workflowInstanceState = workflowInstanceStateRepository.saveAndFlush(workflowInstanceState);

		return newCurrentStep;
	}

	private CurrentStep changeCurrentStep(CurrentStep oldCurrentStep, MdlUser mdlUser, String newStepIdent) {

		oldCurrentStep.removeUsers(mdlUser);
		oldCurrentStep = currentStepRepository.save(oldCurrentStep);

		WorkflowInstanceState workflowInstanceState = oldCurrentStep.getWorkflowInstanceState();

		CurrentStep newCurrentStep = oldCurrentStep.getWorkflowInstanceState().getSteps().parallelStream()
				.filter(c -> c.getStepIdent().equals(newStepIdent)).findFirst()
				.orElseGet(() -> createNewCurrentStep(newStepIdent, workflowInstanceState));

		newCurrentStep.addUsers(mdlUser);

		return currentStepRepository.saveAndFlush(newCurrentStep);
	}

	private Optional<CurrentStep> findCurrentStep(WorkflowInstanceState workflowInstanceState, MdlUser mdlUser) {
		for (CurrentStep currentStep : currentStepRepository.findAll()) {

			if (currentStep.getWorkflowInstanceState().equals(workflowInstanceState)
					&& currentStep.getUsers().contains(mdlUser)) {
				return Optional.of(currentStep);
			}

		}
		return Optional.empty();
	}
	
	private Optional<String> valideRole(String wfModel, Optional<String> role) {
		List<String> roles = INTERPRETER.getWorkflowData(wfModel).getRoles();
		if(role.isPresent()) {
			if(roles.contains(role.get())) {
				LOG.info("Find role : {}", role.get());
				return role;
			}
		}
		
		LOG.info("Role doesn't exist");
		
		if(roles.size() > 0) {
			String oneRole = roles.get(0);
			LOG.info("Take role : {}", oneRole);
			return Optional.of(oneRole);
		}
		
		LOG.error("Impossible to find a role");
		
		return Optional.empty();
	}

	public Optional<StepDTO> getStepDTO(WorkflowInstance workflowInstance, MdlUser mdlUser) {
		LOG.debug("Request StepDTO with {}", workflowInstance, mdlUser);

		Optional<CurrentStep> optCurrentStep = findCurrentStep(workflowInstance.getState(), mdlUser);
		if (!optCurrentStep.isPresent()) {
			LOG.debug("Current Step not found for MdlUser {}", mdlUser);
			return Optional.empty();
		}

		CurrentStep currentStep = optCurrentStep.get();

		WorkflowExecutionStateImpl workflowExecutionStateImpl = new WorkflowExecutionStateImpl(workflowInstance,
				answerRepository, currentStep);
		
		String model = workflowInstance.getWfModel().getBody();

		Optional<String> role = getRole(workflowInstance, mdlUser);
		valideRole(model, role).ifPresent(r -> workflowExecutionStateImpl.setRole(r));

		StepDTOFactory wfStepFactory = INTERPRETER.getStep(model, workflowExecutionStateImpl);

		if (wfStepFactory.getError().isPresent()) {
			EmptyStep emptyStep = new EmptyStep(wfStepFactory.getError().get());
			return Optional.of(emptyStep);
		}

		String nextStepID = wfStepFactory.getCurrentStepID();
		if (!currentStep.getStepIdent().equals(nextStepID)) {
			changeCurrentStep(currentStep, mdlUser, nextStepID);
		}

		if (wfStepFactory.getMailReminder().isPresent()) {
			MailReminder mailReminder = wfStepFactory.getMailReminder().get();
			mailReminder.getNextDateToSend()
					.forEach(date -> newMailSender(date, mdlUser, mailReminder.getObject(), mailReminder.getBody()));
		}

		getAnswers(workflowInstance, mdlUser, nextStepID)
				.forEach(a -> wfStepFactory.addResponses(a.getQuestionIdent(), a.getAnswer()));

		return Optional.of(wfStepFactory.build());
	}

	private void newMailSender(String date, MdlUser mdlUser, String mailObject, String mailBody) {
		LOG.info("Prepare to send mail at {}", date);

		try {
			Date d = new SimpleDateFormat("dd/MM/yy").parse(date);
			Timer timer = new Timer(true);
			Date now = Date.from(Instant.now());
			if (now.before(d) || now.equals(d)) {
				LOG.debug("deamon launch");
				timer.schedule(new TimerTask() {

					@Override
					public void run() {
						LOG.info("send mail");
						mailService.sendEmail(mdlUser.getUser().getEmail(), mailObject, mailBody, false, false);
//						sendMail(mailReminder.getObject(), mailReminder.getBody(), mdlUser.getUser().getEmail());
					}
				}, d);
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private void createDataForNewGuest(MdlUser mdlUser, CurrentStep currentStep, WorkflowInstance workflowInstance) {
		currentStep.addUsers(mdlUser);
		
		Role role = new Role();
		role.setUser(mdlUser);
		role.setWorkflowInstance(workflowInstance);
		
		roleRepository.save(role);
	}

	/**
	 * Create all entities in the database for the {@link WorkflowInstance}
	 * @param wfModel
	 * @param workflowInstance
	 */
	public void initNewWorkflowData(String wfModel, WorkflowInstance workflowInstance) {
		LOG.info("Creating new CurrentStep for workflowModel {}", wfModel);
		
		WorkflowInstanceState workflowInstanceState = new WorkflowInstanceState();
		workflowInstanceState.setWorkflowInstance(workflowInstance);
		
		workflowInstance.setState(workflowInstanceState);
		
		workflowInstanceState = workflowInstanceStateRepository.save(workflowInstanceState);
		
		String stepIdent = INTERPRETER.getWorkflowData(wfModel).getIDFirstStep();
		
		CurrentStep currentStep = createNewCurrentStep(stepIdent, workflowInstanceState);
		
		workflowInstance.getGuests().forEach(u -> createDataForNewGuest(u, currentStep, workflowInstance));
		
		currentStepRepository.save(currentStep);
	}
	
	public List<String> getAllRoles(String wfModel){
		return INTERPRETER.getWorkflowData(wfModel).getRoles();
	}
}
