package org.xtext.metadoodle.interpreter.Implementation;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.xtext.metadoodle.interpreter.Interface.Answer;

public class AnswerImpl implements Answer{
	
	private String userID;
	private String stepID;
	private Map<String, List<String>> answers;
	
	public AnswerImpl(String userID, String stepID, Map<String, List<String>> answers ) {
		Objects.requireNonNull(userID);
		Objects.requireNonNull(stepID);
		Objects.requireNonNull(answers);
		this.userID = userID;
		this.stepID = stepID;
		this.answers = answers;
	}

	@Override
	public String getUserID() {
		return this.userID;
	}

	@Override
	public String getStepID() {
		return this.stepID;
	}

	@Override
	public List<String> getAnswer(String reqID) {
		Objects.requireNonNull(reqID);
		return answers.get(reqID);
	}

}
