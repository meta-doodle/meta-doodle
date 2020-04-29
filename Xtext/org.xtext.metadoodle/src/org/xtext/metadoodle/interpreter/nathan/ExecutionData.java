package org.xtext.metadoodle.interpreter.nathan;

import org.xtext.metadoodle.interpreter.Interface.ID;

public interface ExecutionData {
	ID getNextStepID();
	StepDTO getStepDTO();
}
