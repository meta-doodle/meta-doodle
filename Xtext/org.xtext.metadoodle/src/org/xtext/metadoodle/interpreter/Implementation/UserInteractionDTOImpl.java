package org.xtext.metadoodle.interpreter.Implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xtext.metadoodle.interpreter.Interface.UserInteractionDTO;

public class UserInteractionDTOImpl implements UserInteractionDTO {

	private String title, questionType, response = "";
	private String questionID;
	private boolean alreadyAnswered = false;
	private List<String> possibleAnswer = new ArrayList<>();
	private Map<String, String> options = new HashMap<>();
	
	public UserInteractionDTOImpl(String id, String title, String type) {
		this.questionID = id;
		this.title = title;
		this.questionType = type;
	}
	
	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public String getQuestionID() {
		return this.questionID;
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
		return this.response;
	}
	
	public void setResponse(String response) {
		if(response != null && !response.isBlank()) {
			this.response = response;
			alreadyAnswered = true;
		}
	}
}
