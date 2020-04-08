package org.xtext.metadoodle.interpreter.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.xtext.metadoodle.interpreter.Interface.ID;

public class Form extends UserInteraction {

	private List<QuestionForm> questions;

	public Form(ID id, String comment, InteractionType it) {
		super(id, comment, it);
		this.questions = new ArrayList<>();
	}

	public List<QuestionForm> getQuestions(){
		return this.questions; // TODO rendre immutable.
	}
	
	public void addQuestion(QuestionForm quest) {
		Objects.requireNonNull(quest);
		this.questions.add(quest);
	}

	@Override
	protected String more() {
		// TODO Auto-generated method stub
		return null;
	}
}
