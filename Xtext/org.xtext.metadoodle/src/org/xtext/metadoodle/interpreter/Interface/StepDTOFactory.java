package org.xtext.metadoodle.interpreter.Interface;

import java.util.Optional;

public interface StepDTOFactory {
	String getCurrentStepID();
	
	StepDTO getStepDTO();
	
	
	void addResponse(String questionID, String answer);

	Optional<MailReminder> getMailReminder();
}