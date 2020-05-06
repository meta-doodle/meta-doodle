package org.xtext.metadoodle.interpreter.Implementation;

import java.util.List;
import java.util.Objects;

import org.xtext.metadoodle.interpreter.Interface.WorkflowInstanceData;

public class WorkflowInstanceDataImpl implements WorkflowInstanceData{
	private String name, description, id;
	private List<String> roles;
	
	public WorkflowInstanceDataImpl(String name, String desc, String id, List<String> roles) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(desc);
		Objects.requireNonNull(id);
		Objects.requireNonNull(roles);
		
		this.name = name;
		this.description = desc;
		this.id = id;
		this.roles = roles;
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

	@Override
	public List<String> getRoles() {
		return List.copyOf(this.roles);
	}
}
