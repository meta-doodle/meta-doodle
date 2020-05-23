package org.jhipster.mdl.interpreter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jhipster.mdl.domain.Answer;
import org.jhipster.mdl.domain.CurrentStep;
import org.jhipster.mdl.domain.MdlUser;
import org.jhipster.mdl.domain.WorkflowInstance;
import org.jhipster.mdl.repository.AnswerRepository;
import org.jhipster.mdl.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xtext.metadoodle.interpreter.Interface.WorkflowExecutionState;

public class WorkflowExecutionStateImpl implements WorkflowExecutionState {

	private static final String DEFAULT_ROLE = "ANY_ROLE";

	private WorkflowInstance workflowInstance;

	private String role = DEFAULT_ROLE;

	private CurrentStep currentStep;

	private List<Answer> answers;

	private RoleRepository roleRepository;
	
	private static final Logger LOG = LoggerFactory.getLogger(WorkflowExecutionStateImpl.class);

	private MdlUser mdlUser;

	public WorkflowExecutionStateImpl(WorkflowInstance workflowInstance, MdlUser mdlUser, AnswerRepository answerRepository,
			CurrentStep currentStep, RoleRepository roleRepository) {
		this.workflowInstance = workflowInstance;
		this.mdlUser = mdlUser;
		this.currentStep = currentStep;
		this.roleRepository = roleRepository;
		answers = getAnswersOfThisWFI(workflowInstance, answerRepository);
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	/**
	 * List of the {@link Answer} relative to the workflowInstance executed
	 * @param workflowInstance
	 * @param mdlUser
	 * @param answerRepository
	 * @return The list of Answers
	 */
	private List<Answer> getAnswersOfThisWFI(WorkflowInstance workflowInstance, AnswerRepository answerRepository) {
		return answerRepository.findAll().parallelStream().filter(a -> a.getWorkflowInstance().equals(workflowInstance))
				.collect(Collectors.toList());
	}

	@Override
	public int getNumberOfUser() {
		int nbUsers = roleRepository.findRoleByWorkflowInstanceIdAndRole(workflowInstance.getId(), role).size();
		LOG.info("Found "+nbUsers+" users in this step");
		return nbUsers;
	}

	@Override
	public String getCurrentStepID() {
		return currentStep.getStepIdent();
	}

	@Override
	public int getNumberAnwers(String stepID) {
		int count = 0;
		for (Answer answer : answers) {
			if (answer.getStepIdent().equals(stepID)) {
				count++;
			}
		}
		LOG.info("Found "+count+" answers in this step");
		return count;
	}

	@Override
	public Optional<String> getPreviousAnswer(String questionID, String stepID) {
		for (Answer answer : answers) {
			if (answer.getQuestionIdent().equals(questionID) && answer.getStepIdent().equals(stepID) && answer.getUser().equals(mdlUser)) {
				return Optional.of(answer.getAnswer());
			}
		}
		return Optional.empty();
	}

	@Override
	public String getRole() {
		return role;
	}

}
