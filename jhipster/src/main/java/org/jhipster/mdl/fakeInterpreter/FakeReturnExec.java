package org.jhipster.mdl.fakeInterpreter;

import org.jhipster.mdl.workflow.to_transfert_data.WorkflowStepData;

public class FakeReturnExec {
	public final WorkflowStepData stepData;
	public final int nextStep;

	public FakeReturnExec(WorkflowStepData stepData, int nextStep) {
		this.stepData = stepData;
		this.nextStep = nextStep;
	}
}
