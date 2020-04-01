package org.xtext.metadoodle.interpreter;

import java.util.ArrayList;
import java.util.List;

public class Form extends UserInteraction{

	private ID id;
	private InteractionType it;
	private String title;
	private List<String> possibleAnswer;
	private AnswerType at;
	
	public Form(
			ID id, 
			InteractionType it, 
			String title, 
			AnswerType at) {
		this(id, it, title, new ArrayList<String>(), at);
	}
	
	public Form(
			ID id, 
			InteractionType it, 
			String title, 
			List<String> pa, 
			AnswerType at) {
		this.id = id;
		this.it = it;
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
	
	public List<String> getPossibleAnswers(){
		return new ArrayList<>(this.possibleAnswer);
	}
	
	public AnswerType getAnswerType() {
		return this.at;
	}
}
