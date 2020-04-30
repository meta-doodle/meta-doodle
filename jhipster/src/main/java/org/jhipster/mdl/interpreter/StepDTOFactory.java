package org.jhipster.mdl.interpreter;

import org.jhipster.mdl.workflow.to_transfert_data.StepDTO;

public interface StepDTOFactory {
	String getCurrentStepID();
	
	StepDTO build();
	void addResponse(String questionID, String answer);
}
