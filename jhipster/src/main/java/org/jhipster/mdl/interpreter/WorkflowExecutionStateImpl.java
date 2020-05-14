package org.jhipster.mdl.interpreter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jhipster.mdl.domain.CurrentStep;
import org.jhipster.mdl.domain.MdlUser;
import org.jhipster.mdl.domain.WorkflowInstance;
import org.jhipster.mdl.repository.AnswerRepository;
import org.jhipster.mdl.repository.CurrentStepRepository;
import org.xtext.metadoodle.interpreter.Implementation.IDImpl;
import org.xtext.metadoodle.interpreter.Interface.Answer;
import org.xtext.metadoodle.interpreter.Interface.ID;
import org.xtext.metadoodle.interpreter.Interface.RetainedChoice;
import org.xtext.metadoodle.interpreter.Interface.WorkflowExecutionState;

public class WorkflowExecutionStateImpl implements WorkflowExecutionState {

	private WorkflowInstance workflowInstance;
	private MdlUser mdlUser;

	private CurrentStepRepository currentStepRepository;
	private AnswerRepository answerRepository;

	private boolean endOfStep = false;

	public WorkflowExecutionStateImpl(WorkflowInstance workflowInstance, MdlUser mdlUser,
			CurrentStepRepository currentStepRepository, AnswerRepository answerRepository) {
		this.workflowInstance = workflowInstance;
		this.mdlUser = mdlUser;
		this.currentStepRepository = currentStepRepository;
		this.answerRepository = answerRepository;
	}

	public WorkflowExecutionStateImpl setEndOfStep(boolean endOfStep) {
		this.endOfStep = endOfStep;
		return this;
	}

	public WorkflowInstance getWorkflowInstance() {
		return workflowInstance;
	}
	
	public Optional<CurrentStep> findCurrentStep() {
		for (CurrentStep currentStep : currentStepRepository.findAllWithEagerRelationships()) {
			if (currentStep.getUsers().contains(mdlUser)
					&& currentStep.getWorkflowInstanceState().getId() == workflowInstance.getState().getId()) {
				return Optional.of(currentStep);
			}
		}
		return Optional.empty();
	}
	
	public CurrentStepRepository getCurrentStepRepository() {
		return currentStepRepository;
	}
	
	public MdlUser getMdlUser() {
		return mdlUser;
	}
	
	public boolean isEndOfStep() {
		return endOfStep;
	}

	private List<org.jhipster.mdl.domain.Answer> getListAnswer(String stepIdent) {
		return answerRepository
				.findAll().parallelStream().filter(a -> a.getWorkflowInstance().equals(workflowInstance)
						&& a.getStepIdent().equals(stepIdent) && a.getUser().equals(mdlUser))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Answer> getCurrentAnswer() {
		Optional<CurrentStep> currentStep = findCurrentStep();
		if (currentStep.isPresent()) {
			Answer answer = new Answer() {

				@Override
				public ID getUserID() {
					return new IDImpl(mdlUser.getUser().getLogin());
				}

				@Override
				public ID getStepID() {
					return new IDImpl(currentStep.get().getStepIdent());
				}

				@Override
				public List<String> getAnswer(ID id) {
					String answerID = id.getID();
					List<String> list = answerRepository.findAll().parallelStream()
							.filter(a -> a.getQuestionIdent().equals(answerID)
									&& a.getStepIdent().equals(currentStep.get().getStepIdent())
									&& a.getUser().equals(mdlUser))
							.map(a -> a.getAnswer()).collect(Collectors.toList());
					return list;
				}
			};
			return Optional.of(answer);
		}
		return Optional.empty();
	}

	@Override
	public ID getCurrentStepID() {
		String id = "Error";
		if (findCurrentStep().isPresent()) {
			id = findCurrentStep().get().getStepIdent();
		}
		return new IDImpl(id);
	}

	@Override
	public int getNumberAnwers(ID id) {
		Optional<CurrentStep> currentStep = findCurrentStep();
		if (currentStep.isPresent()) {
			return getListAnswer(currentStep.get().getStepIdent()).size();
		}
		return 0;
	}

	@Override
	public int getNumberOfUser() {
		return workflowInstance.getGuests().size();
	}

	@Override
	public Optional<Answer> getPreviousAnswer(ID arg0, ID arg1) {
		return Optional.empty();
	}

	@Override
	public RetainedChoice getPreviousRetainedChoice(String arg0) {
		return null;
	}

	@Override
	public boolean isStepComplete() {
		return endOfStep;
	}

}
