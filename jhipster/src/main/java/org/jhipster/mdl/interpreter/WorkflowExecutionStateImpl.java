package org.jhipster.mdl.interpreter;

import java.util.Optional;

import org.jhipster.mdl.domain.CurrentStep;
import org.jhipster.mdl.domain.MdlUser;
import org.jhipster.mdl.domain.WorkflowInstanceState;
import org.xtext.metadoodle.interpreter.Implementation.IDImpl;
import org.xtext.metadoodle.interpreter.Interface.Answer;
import org.xtext.metadoodle.interpreter.Interface.ID;
import org.xtext.metadoodle.interpreter.Interface.RetainedChoice;
import org.xtext.metadoodle.interpreter.Interface.WorkflowExecutionState;

public class WorkflowExecutionStateImpl implements WorkflowExecutionState {

	private WorkflowInstanceState workflowInstanceState;
	private MdlUser mdlUser;

	public WorkflowExecutionStateImpl(WorkflowInstanceState workflowInstanceState, MdlUser mdlUser) {
		this.workflowInstanceState = workflowInstanceState;
		this.mdlUser = mdlUser;
	}

	@Override
	public Optional<Answer> getCurrentAnswer() {
		return Optional.empty();
	}

	@Override
	public ID getCurrentStepID() {
		Optional<CurrentStep> optStep = workflowInstanceState.findCurrentStepContainingMdlUser(mdlUser);
		if(optStep.isPresent()) {
			CurrentStep step = optStep.get();
			return new IDImpl(step.getStepIdent());
		}
		return new IDImpl("fatal error");
	}

	@Override
	public int getNumberAnwers(ID id) {
		Optional<CurrentStep> optStep = workflowInstanceState.findCurrentStepContainingMdlUser(mdlUser);
		if(optStep.isPresent()) {
			CurrentStep step = optStep.get();
			return step.getNumberOfAnswer();
		}
		return 0;
	}

	@Override
	public int getNumberOfUser() {
		Optional<Integer> nbUsers = workflowInstanceState.getSteps().parallelStream()
				.map(step -> step.getUsers().size()).reduce((x, y) -> x + y);
		if(nbUsers.isPresent()) {
			return nbUsers.get();
		} else {
			return 0;
		}
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
	public ID getUserID() {
		return null;
	}

}
