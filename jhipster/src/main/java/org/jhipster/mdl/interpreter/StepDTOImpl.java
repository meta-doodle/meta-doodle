package org.jhipster.mdl.interpreter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.jhipster.mdl.workflow.to_transfert_data.StepDTO;
import org.jhipster.mdl.workflow.to_transfert_data.UserInteractionDTO;

public class StepDTOImpl implements StepDTO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<UserInteractionDTOImpl> userInteractions = new ArrayList<>();

	private String stepID;

	public StepDTOImpl(String stepID) {
		this.stepID = stepID;
	}

	public void addResponse(String questionID, String answer) {
		for (UserInteractionDTOImpl userInteractionDTOImpl : userInteractions) {
			if (userInteractionDTOImpl.getQuestionID().equals(questionID)) {
				userInteractionDTOImpl.addAnswer(answer);
			}
		}
	}

	public void addUserInteraction(UserInteractionDTOImpl userInteractionDTOImpl) {
		userInteractions.add(userInteractionDTOImpl);
	}

	@Override
	public List<? extends UserInteractionDTO> getUserInteractionDTOs() {
		return userInteractions;
	}

	@Override
	public String getStepID() {
		return stepID;
	}

}
