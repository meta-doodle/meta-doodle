package org.xtext.metadoodle.interpreter.Implementation;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;

import org.xtext.metadoodle.interpreter.Interface.WorkflowInstanceData;

public class WorkflowInstanceDataImpl implements WorkflowInstanceData{
	private String name, description, id;
	private List<String> roles;
	private BiFunction<String, String, Optional<String>> getterQuestionTitle;
	
	public WorkflowInstanceDataImpl(String name, String desc, String id, List<String> roles, BiFunction<String, String, Optional<String>> getterQuestionTitle) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(desc);
		Objects.requireNonNull(id);
		Objects.requireNonNull(roles);
		
		this.name = name;
		this.description = desc;
		this.id = id;
		this.roles = roles;
		this.getterQuestionTitle = getterQuestionTitle;
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

	@Override
	public Optional<String> getQuestionTitle(String stepID, String questionID) {
		return getterQuestionTitle.apply(stepID, questionID);
	}
}
