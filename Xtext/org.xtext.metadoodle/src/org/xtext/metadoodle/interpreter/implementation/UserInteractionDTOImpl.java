package org.xtext.metadoodle.interpreter.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.xtext.metadoodle.interpreter.Interface.Answer;
import org.xtext.metadoodle.interpreter.Interface.UserInteractionDTO;
import org.xtext.metadoodle.interpreter.Interface.WorkflowExecutionState;

//TODO change method names to reflect the actual use (maybe)
// IE : getQuestionType returns UserInteractionType and not only questions...
public class UserInteractionDTOImpl implements UserInteractionDTO {
	
	private String title;
	private UserInteractionType type;
	private Map<String, String> options = new HashMap<>();
	private List<String> possibleanswers = new ArrayList<>();
	private String id;
	private boolean isAnswered = false;
	private String answer = "";
	
	public UserInteractionDTOImpl(String title, UserInteractionType type, String id) {
		this.id = id;
		this.title = title;
		this.type = type;
	}
	
	public void setAnswer(String answer) {
		if (!answer.isBlank()) {
			isAnswered = true;
			this.answer = answer;
		}
	}
	
	//functions used for the mid-end of Compilation
	public void addOption(String key, String value) {
		options.put(key, value);
	}
 
	public void addPossibleAnswer(String answer) {
		possibleanswers.add(answer);
	}
	
	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public String getQuestionType() {
		return type.name();
	}

	@Override
	public String getQuestionID() {
		return this.id;
	}


	@Override
	public List<String> getPossibleAnswers() {
		return possibleanswers;
	}

	@Override
	public Map<String, String> getOptions() {
		return options;
	}

	@Override
	public boolean isAlreadyAnswered() {
		return isAnswered;
	}

	@Override
	public String getResponses() {
		return this.answer;
	}
	
	@Override
	public String toString() {

		String ui = "{";
		ui += "\nTitle : "+ this.title;
		ui += "\nType : "+ this.type;
		ui += "\nID : "+ this.id;
		ui += "Possible answers : {";
		for (String string : possibleanswers) {
			ui += "\n"+ string;
		}
		ui+="}\n options : {";
		for (Entry<String, String> e : options.entrySet()) {
			ui+= "\n"+ e.getKey() +" -> "+ e.getValue();
		}
		ui+= "}";
		return ui;

	}

}
