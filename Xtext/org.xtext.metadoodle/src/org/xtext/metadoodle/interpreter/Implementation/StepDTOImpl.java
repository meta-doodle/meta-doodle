package org.xtext.metadoodle.interpreter.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.xtext.metadoodle.interpreter.Interface.StepDTO;
import org.xtext.metadoodle.interpreter.Interface.UserInteractionDTO;

public class StepDTOImpl implements StepDTO {

	private List<UserInteractionDTOImpl> UserInteractions;
	private String stepDescription;
	private String stepID;
	
	public StepDTOImpl(String desc, String id) {
		Objects.requireNonNull(desc);
		Objects.requireNonNull(id);
		
		this.UserInteractions = new ArrayList<>();
		this.stepDescription = desc;
		this.stepID = id;
	}
	
	@Override
	public List<UserInteractionDTO> getInteractions() {
		return List.copyOf(this.UserInteractions);
	}

	public void addUserInteraction(UserInteractionDTOImpl ui) {
		Objects.requireNonNull(ui);
		this.UserInteractions.add(ui);
	}
	
	UserInteractionDTOImpl getUserInteractionDTO(String id) {
		Objects.requireNonNull(id);
		for(UserInteractionDTOImpl ui : this.UserInteractions) {
			if(ui.getQuestionID().equals(id)) {
				return ui;
			}
		}
		
		throw new IllegalArgumentException("La questionID : " + id + " est inconnu dans l'étape " + stepID);
	}
	
	@Override
	public String getStepDescription() {
		return this.stepDescription;
	}

	@Override
	public String getStepID() {
		return this.stepID.toString();
	}
}
