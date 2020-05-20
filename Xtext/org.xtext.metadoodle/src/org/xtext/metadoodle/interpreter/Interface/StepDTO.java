package org.xtext.metadoodle.interpreter.Interface;

import java.util.List;

public interface StepDTO {
	public List<? extends UserInteractionDTO> getUserInteractionDTOs();
	
	public String getStepDescription();
	
	public String getStepID();
}
