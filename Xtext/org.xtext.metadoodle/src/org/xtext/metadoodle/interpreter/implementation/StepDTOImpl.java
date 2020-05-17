package org.xtext.metadoodle.interpreter.implementation;

import java.util.ArrayList;
import java.util.List;

import org.xtext.metadoodle.interpreter.Interface.StepDTO;
import org.xtext.metadoodle.interpreter.Interface.UserInteractionDTO;

public class StepDTOImpl implements StepDTO{
	private String stepid;
	private List<UserInteractionDTOImpl> lui = new ArrayList<>();	
	
	public StepDTOImpl(String stepid) {
		this.stepid = stepid;
	}
	
	public UserInteractionDTOImpl addUserInteraction(String title, UserInteractionType type, String id) {
		UserInteractionDTOImpl ui = new UserInteractionDTOImpl(title, type, id);
		lui.add(ui);
		return ui;
	}

	public void addResponse(String uiID, String answer) {
		for (UserInteractionDTOImpl ui : this.lui){
			if (ui.getQuestionID().equals(uiID)) {
				ui.setAnswer(answer);
			}
		}
	}
	
	@Override
	public List<? extends UserInteractionDTO> getUserInteractionDTOs() {
		return lui;
	}

	@Override
	public String getStepID() {
		return this.stepid;
	}
	
	@Override
	public String toString() {
		String steps = "";
		steps+= "step id : "+this.stepid;
		for (UserInteractionDTOImpl ui : lui) {
			steps+= "\n"+ui.toString();
		}
		
		return steps;
	}

}
