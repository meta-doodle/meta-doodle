package org.xtext.metadoodle.interpreter.Implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.xtext.metadoodle.interpreter.Interface.UserInteractionDTO;

public class UserInteractionDTOImpl implements UserInteractionDTO {

	private String title, questionType, responses;
	private String questionID;
	private boolean alreadyAnswered;
	private List<String> possibleAnswer;
	private Map<String, String> options;
	
	public UserInteractionDTOImpl() {
		this.possibleAnswer = new ArrayList<>();
		this.options = new HashMap<String, String>();
		this.responses = null;
	}
	
	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public String getQuestionID() {
		return this.questionID.toString();
	}

	@Override
	public String getQuestionType() {
		return this.questionType;
	}

	@Override
	public boolean isAlreadyAnswered() {
		return this.alreadyAnswered;
	}

	@Override
	public List<String> getPossibleAnswers() {
		return List.copyOf(this.possibleAnswer);
	}

	@Override
	public Map<String, String> getOptions() {
		return Map.copyOf(this.options);
	}

	@Override
	public String getResponses() {
		return this.responses;
	}
	
	public void addResponse(String response) {
		Objects.requireNonNull(response);
		
		if(this.responses == null) {
			this.responses = "";
		}
		
		this.responses += response + ",";
	}
}
