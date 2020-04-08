package org.xtext.metadoodle.interpreter.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.xtext.metadoodle.interpreter.Interface.ID;

public class Form extends UserInteraction {

	private ID id;
	private InteractionType it;
	private String title;
	private List<String> possibleAnswer;
	private AnswerType at;

	public Form(ID id, String comment, InteractionType it, String title, AnswerType at) {
		this(id, comment, it, title, new ArrayList<String>(), at);
	}

	public Form(
			ID id, 
			String comment, 
			InteractionType it, 
			String title, 
			List<String> pa, 
			AnswerType at) {
		super(id, comment, it);
		this.title = title;
		this.possibleAnswer = pa;
		this.at = at;
	}

	@Override
	public ID getStepID() {
		return this.id;
	}

	@Override
	public InteractionType getType() {
		return this.it;
	}

	public String getTitle() {
		return this.title;
	}

	public List<String> getPossibleAnswers() {
		return new ArrayList<>(this.possibleAnswer);
	}

	public AnswerType getAnswerType() {
		return this.at;
	}

	@Override
	protected String more() {
		// TODO Auto-generated method stub
		return null;
	}
}
