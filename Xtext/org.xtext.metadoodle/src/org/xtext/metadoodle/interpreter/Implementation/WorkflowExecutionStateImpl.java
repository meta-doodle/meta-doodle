package org.xtext.metadoodle.interpreter.Implementation;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.xtext.metadoodle.interpreter.Interface.Answer;
import org.xtext.metadoodle.interpreter.Interface.ID;
import org.xtext.metadoodle.interpreter.Interface.RetainedChoice;
import org.xtext.metadoodle.interpreter.Interface.WorkflowExecutionState;


public class WorkflowExecutionStateImpl implements WorkflowExecutionState {

	private ID stepID;
	private ID userID;
	private int nbUsers;
	private List<Answer> listAnswers;

	
	public WorkflowExecutionStateImpl(ID stepID, ID userID, int nbUsers, List<Answer> answers) {
		Objects.requireNonNull(stepID);
		Objects.requireNonNull(userID);
		Objects.requireNonNull(nbUsers);
		Objects.requireNonNull(answers);

		this.stepID = stepID;
		this.userID = userID;
		this.nbUsers = nbUsers;
		this.listAnswers = answers;
		
	}
	
	
	
	@Override
	public int getNumberOfUser() {
		return nbUsers;
	}

	@Override
	public ID getUserID() {
		return this.userID;
	}

	@Override
	public ID getCurrentStepID() {
		return this.stepID;
	}

	@Override
	public int getNumberAnwers(ID stepID) {
		Objects.requireNonNull(stepID);
		int res = 0;
		for(Answer a : listAnswers) {
			if (stepID.getID() == a.getStepID().getID())
				res++;
		}
		return res;
	}
	
	//voir comment accéder a la question précédente
	@Override
	public Optional<Answer> getPreviousAnswer(ID reqID, ID stepID) {
		return null;
	}

	@Override
	public RetainedChoice getPreviousRetainedChoice(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Answer> getCurrentAnswer() {
		// TODO Auto-generated method stub
		return null;
	}

}
