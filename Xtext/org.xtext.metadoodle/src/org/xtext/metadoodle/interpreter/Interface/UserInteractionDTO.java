package org.xtext.metadoodle.interpreter.Interface;
import java.util.List;
import java.util.Map;

public interface UserInteractionDTO {
	String getTitle();
	String getQuestionID();
	String getQuestionType();
	List<String> getPossibleAnswers();
	Map<String, String> getOptions();
	
	boolean isAlreadyAnswered();
	String getResponses();
}