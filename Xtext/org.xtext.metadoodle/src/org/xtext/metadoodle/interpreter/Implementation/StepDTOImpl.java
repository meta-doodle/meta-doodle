package org.xtext.metadoodle.interpreter.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.xtext.metadoodle.interpreter.Interface.StepDTO;
import org.xtext.metadoodle.interpreter.Interface.UserInteractionDTO;
import org.xtext.metadoodle.mDL.UserInteractionLan;
import org.xtext.metadoodle.mDL.WorkflowStepLan;

public class StepDTOImpl implements StepDTO {

	private List<UserInteractionDTOImpl> userInteractions;
	private String stepDescription;
	private String stepID;
	
	public StepDTOImpl(String desc, String id) {
		Objects.requireNonNull(desc);
		Objects.requireNonNull(id);
		
		this.userInteractions = new ArrayList<>();
		this.stepDescription = desc;
		this.stepID = id;
	}
	
	public StepDTOImpl(WorkflowStepLan workflowStepLan) {
		stepDescription = workflowStepLan.getComment();
		stepID = workflowStepLan.getName();
		
		UserInteractionSwitchBuilder userInteractionBuilder = new UserInteractionSwitchBuilder();
		for (UserInteractionLan userInteraction : workflowStepLan.getUserInteraction()) {
			userInteractions = userInteractionBuilder.doSwitch(userInteraction);
		}
	}
	
	@Override
	public List<UserInteractionDTO> getInteractions() {
		return List.copyOf(this.userInteractions);
	}

	public void addUserInteraction(UserInteractionDTOImpl ui) {
		Objects.requireNonNull(ui);
		this.userInteractions.add(ui);
	}
	
	UserInteractionDTOImpl getUserInteractionDTO(String id) {
		Objects.requireNonNull(id);
		for(UserInteractionDTOImpl ui : this.userInteractions) {
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
