package org.xtext.metadoodle.interpreter.Implementation;

import java.util.Objects;

import org.xtext.metadoodle.interpreter.Interface.WorkflowInstanceData;

public class WorkflowInstanceDataImpl implements WorkflowInstanceData{
	private String name, description, id;
	
	public WorkflowInstanceDataImpl(String name, String desc, String id) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(desc);
		Objects.requireNonNull(id);
		
		this.name = name;
		this.description = desc;
		this.id = id;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getIDFirstStep() {
		return id;
	}
}
