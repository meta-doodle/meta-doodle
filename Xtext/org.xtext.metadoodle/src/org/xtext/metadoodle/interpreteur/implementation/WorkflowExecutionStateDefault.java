package org.xtext.metadoodle.interpreteur.implementation;

import java.util.Optional;

import org.xtext.metadoodle.interpreter.Implementation.IDImpl;
import org.xtext.metadoodle.interpreter.Interface.Answer;
import org.xtext.metadoodle.interpreter.Interface.ID;
import org.xtext.metadoodle.interpreter.Interface.RetainedChoice;
import org.xtext.metadoodle.interpreter.Interface.WorkflowExecutionState;


//CLASSE DE TEST !!!
class WorkflowExecutionStateDefault implements WorkflowExecutionState {
	
	private String stepID;

	public WorkflowExecutionStateDefault(String stepID) {
		this.stepID = stepID;
	}

	@Override
	public int getNumberOfUser() {
		return 6;
	}

	@Override
	public ID getCurrentStepID() {
		return new IDImpl(stepID);
	}

	@Override
	public int getNumberAnwers(ID stepID) {
		return 5;
	}

	@Override
	public Optional<Answer> getPreviousAnswer(ID reqID, ID stepID) {
		return Optional.empty();
	}

	@Override
	public RetainedChoice getPreviousRetainedChoice(String name) {
		return null;
	}

	@Override
	public Optional<Answer> getCurrentAnswer() {
		return Optional.empty();
	}

	@Override
	public boolean isStepComplete() {
		return false;
	}

}
