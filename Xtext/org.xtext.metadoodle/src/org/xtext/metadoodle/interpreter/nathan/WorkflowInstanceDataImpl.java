package org.xtext.metadoodle.interpreter.nathan;

import org.xtext.metadoodle.interpreter.Interface.WorkflowInstanceData;
import org.xtext.metadoodle.mDL.WorkflowLan;

class WorkflowInstanceDataImpl implements WorkflowInstanceData {
	
	private WorkflowLan workflowLan;

	public WorkflowInstanceDataImpl(WorkflowLan workflowLan) {
		this.workflowLan = workflowLan;
	}

	@Override
	public String getName() {
		return workflowLan.getName();
	}

	@Override
	public String getDescription() {
		return workflowLan.getDesc();
	}

	@Override
	public String getIDFirstStep() {
		if(workflowLan.getSteps().size() > 0) {
			return workflowLan.getSteps().get(0).getName();
		}
		return null;
	}

}
