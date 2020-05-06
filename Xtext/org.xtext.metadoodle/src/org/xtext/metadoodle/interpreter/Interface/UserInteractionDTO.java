package org.xtext.metadoodle.interpreter.Interface;

import java.util.List;
import java.util.Map;

public interface UserInteractionDTO {
	public String getTitle();
	
	public String getQuestionID();
	
	public String getQuestionType();
	
	public boolean isAlreadyAnswered();
	
	public List<String> getPossibleAnswers();
	
	public Map<String, String> getOptions();
	
	public String getResponses();
}
