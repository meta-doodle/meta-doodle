package org.jhipster.mdl.workflow.to_transfert_data;

import java.util.List;

public interface StepDTO {
	List<? extends UserInteractionDTO> getUserInteractionDTOs();
	String getStepID();
}
