package org.xtext.metadoodle.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class WorkflowStepImpl implements WorkflowStep{
	private ID name;
	private String description;
	private List<UserInteraction> interactions;
	private Boolean hasReminder;
	private MailReminder mail = null;

	/**
	 * Le constructeur.
	 * 
	 * 
	 * @param name 
	 * @param desc
	 */
	public WorkflowStepImpl(ID name, String desc) {
		Objects.requireNonNull(name);
		
		this.name = name;
		this.description = desc;
		this.interactions = new ArrayList<>();
		this.hasReminder = false;
	}
	
	@Override
	public ID getId() {
		return this.name;
	}

	@Override
	public List<ID> getIDOfNextStep() {
		return null; // TODO
	}

	@Override
	public Optional<String> getComment() {
		return Optional.ofNullable(this.description);
	}

	@Override
	public void addUserInteraction(UserInteraction interaction) {
		Objects.requireNonNull(interaction);
		this.interactions.add(interaction);
	}

	@Override
	public List<UserInteraction> getUserInteractions() {
		return this.interactions;
	}

	@Override
	public boolean hasReminder() {
		return this.hasReminder;
	}

	@Override
	public MailReminder getReminder() {
		return this.mail;
	}

	@Override
	public void setReminder(MailReminder mail) {
		Objects.requireNonNull(mail);
		this.mail = mail;
	}
	
	public String toString() {
		return this.name + " : " + this.description;
	}
}
