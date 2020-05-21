package org.jhipster.mdl.interpreter;

import java.util.ArrayList;
import java.util.List;

import org.xtext.metadoodle.interpreter.Interface.StepDTO;
import org.xtext.metadoodle.interpreter.Interface.UserInteractionDTO;

public class EmptyStep implements StepDTO {
	
	private List<UserInteractionDTO> userInteractionDTOs = new ArrayList<>();
	
	public EmptyStep() {
	}

	@Override
	public List<? extends UserInteractionDTO> getUserInteractionDTOs() {
		return userInteractionDTOs;
	}

	@Override
	public String getStepID() {
		return "Empty Step";
	}

}
