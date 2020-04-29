package org.xtext.metadoodle.interpreter.nathan;

import java.util.ArrayList;
import java.util.List;

class StepImpl implements StepDTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<UserInteractionDTO> userInteractionDTOs;
	
	public StepImpl(List<UserInteractionDTO> userInteractionDTOs) {
		this.userInteractionDTOs = userInteractionDTOs;
	}
	
	public StepImpl(UserInteractionDTO...userInteractionDTOs) {
		this.userInteractionDTOs = new ArrayList<>();
		for (UserInteractionDTO userInteractionDTO : userInteractionDTOs) {
			this.userInteractionDTOs.add(userInteractionDTO);
		}
	}

	@Override
	public List<UserInteractionDTO> getUserInteraction() {
		return userInteractionDTOs;
	}
	
	@Override
	public String toString() {
		return userInteractionDTOs.toString();
	}

}
