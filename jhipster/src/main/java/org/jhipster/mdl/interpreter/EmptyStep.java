package org.jhipster.mdl.interpreter;

import java.util.ArrayList;
import java.util.List;

import org.xtext.metadoodle.interpreter.Interface.StepDTO;
import org.xtext.metadoodle.interpreter.Interface.UserInteractionDTO;

public class EmptyStep implements StepDTO {
	
	private List<UserInteractionDTO> userInteractionDTOs = new ArrayList<>();
	private String errorMessage;
	
	public EmptyStep(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public List<UserInteractionDTO> getInteractions() {
		return userInteractionDTOs;
	}

	@Override
	public String getStepDescription() {
		return errorMessage;
	}

	@Override
	public String getStepID() {
		return "Empty Step";
	}

}
