package org.xtext.metadoodle.interpreter.Implementation;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.xtext.metadoodle.interpreter.Interface.Answer;
import org.xtext.metadoodle.interpreter.Interface.ID;

public class AnswerImpl implements Answer{
	
	private ID userID;
	private ID stepID;
	private Map<ID, List<String>> answers;
	
	public AnswerImpl(ID userID, ID stepID, Map<ID, List<String>> answers ) {
		Objects.requireNonNull(userID);
		Objects.requireNonNull(stepID);
		Objects.requireNonNull(answers);
		this.userID = userID;
		this.stepID = stepID;
		this.answers = answers;
	}

	@Override
	public ID getUserID() {
		return this.userID;
	}

	@Override
	public ID getStepID() {
		return this.stepID;
	}

	@Override
	public List<String> getAnswer(ID reqID) {
		Objects.requireNonNull(reqID);
		return answers.get(reqID);
	}

}
