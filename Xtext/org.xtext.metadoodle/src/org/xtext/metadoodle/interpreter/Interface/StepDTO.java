package org.xtext.metadoodle.interpreter.Interface;

import java.util.List;

public interface StepDTO {
	List<? extends UserInteractionDTO> getUserInteractionDTOs();
	String getStepID();
}