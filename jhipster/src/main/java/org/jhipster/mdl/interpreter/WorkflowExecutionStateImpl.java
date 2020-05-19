package org.jhipster.mdl.interpreter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jhipster.mdl.domain.Answer;
import org.jhipster.mdl.domain.CurrentStep;
import org.jhipster.mdl.domain.WorkflowInstance;
import org.jhipster.mdl.repository.AnswerRepository;
import org.xtext.metadoodle.interpreter.Interface.WorkflowExecutionState;

public class WorkflowExecutionStateImpl implements WorkflowExecutionState {

	private static final String DEFAULT_ROLE = "ANY_ROLE";

	private WorkflowInstance workflowInstance;

	private String role = DEFAULT_ROLE;

	private CurrentStep currentStep;

	private List<Answer> answers;

	public WorkflowExecutionStateImpl(WorkflowInstance workflowInstance, AnswerRepository answerRepository,
			CurrentStep currentStep) {
		this.workflowInstance = workflowInstance;
		this.currentStep = currentStep;
		answers = getAnswersOfThisWFI(workflowInstance, answerRepository);
	}

	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * List of the {@link Answer} relative to the workflowInstance executed
	 * 
	 * @return A list of {@link Answer}
	 */
	private List<Answer> getAnswersOfThisWFI(WorkflowInstance workflowInstance, AnswerRepository answerRepository) {
		return answerRepository.findAll().parallelStream().filter(a -> a.getWorkflowInstance().equals(workflowInstance))
				.collect(Collectors.toList());
	}

	@Override
	public int getNumberOfUser() {
		return workflowInstance.getGuests().size();
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
		return count;
	}

	@Override
	public Optional<String> getPreviousAnswer(String questionID, String stepID) {
		for (Answer answer : answers) {
			if (answer.getQuestionIdent().equals(questionID) && answer.getStepIdent().equals(stepID)) {
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
