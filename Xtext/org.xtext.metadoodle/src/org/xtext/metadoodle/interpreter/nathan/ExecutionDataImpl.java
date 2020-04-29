package org.xtext.metadoodle.interpreter.nathan;

import org.xtext.metadoodle.interpreter.Interface.ID;

class ExecutionDataImpl implements ExecutionData {
	
	private ID nextStepID;
	private StepDTO stepDTO;

	public ExecutionDataImpl(ID nextStepID, StepDTO stepDTO) {
		this.nextStepID = nextStepID;
		this.stepDTO = stepDTO;
	}

	@Override
	public ID getNextStepID() {
		return nextStepID;
	}

	@Override
	public StepDTO getStepDTO() {
		return stepDTO;
	}
	
}
