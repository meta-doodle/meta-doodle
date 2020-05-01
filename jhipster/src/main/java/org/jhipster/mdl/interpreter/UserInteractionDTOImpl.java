package org.jhipster.mdl.interpreter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jhipster.mdl.workflow.to_transfert_data.UserInteractionDTO;

public class UserInteractionDTOImpl implements UserInteractionDTO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String questionID;
	private String questionType;
	
	private boolean isAlreadyAnswered;
	private String responses = "";

	private Map<String, String> options = new HashMap<>();

	private List<String> possibleAnswers = new ArrayList<>();
	
	public UserInteractionDTOImpl(String title, String questionID, String questionType) {
		this.title = title;
		this.questionID = questionID;
		this.questionType = questionType;
	}
	
	public void addAnswer(String answer) {
		isAlreadyAnswered = true;
		responses = answer;
	}
	
	public void setPossibleAnswers(List<String> possibleAnswers) {
		this.possibleAnswers = possibleAnswers;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getQuestionID() {
		return questionID;
	}

	@Override
	public String getQuestionType() {
		return questionType;
	}

	@Override
	public List<String> getPossibleAnswers() {
		return possibleAnswers;
	}

	@Override
	public Map<String, String> getOptions() {
		return options;
	}

	@Override
	public boolean isAlreadyAnswered() {
		return isAlreadyAnswered;
	}

	@Override
	public String getResponses() {
		return responses;
	}

}
