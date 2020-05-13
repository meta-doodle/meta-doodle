package org.xtext.metadoodle.interpreter.Interface;

public interface StepDTOFactory {
	String getCurrentStepID();
	
	StepDTO build();
	void addResponse(String questionID, String answer);
}