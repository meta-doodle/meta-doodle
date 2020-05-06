package org.xtext.metadoodle.interpreter.Interface;

import java.util.List;

public interface StepDTO {
	public List<UserInteractionDTO> getInteractions();
	
	public String getStepDescription();
	
	public String getStepID();
}
