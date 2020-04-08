package org.xtext.metadoodle.interpreter.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuestionForm {
	
	private String title;
	private AnswerType type;
	private List<String> possibleAnswer;
	
	public QuestionForm(String title, AnswerType at) {
		this.title = title;
		this.type = at;
		this.possibleAnswer = new ArrayList<>();
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public AnswerType getAnswerType() {
		return this.type;
	}
	
	public void addAnswer(String possibleAnswer) {
		Objects.requireNonNull(possibleAnswer);
		this.possibleAnswer.add(possibleAnswer);
	}
	
	public List<String> getPossibleAnswer(){
		return this.possibleAnswer; // TODO rendre immutable.
	}
	
	public String toString() {
		String ret = "Titre : " + title + " | type de réponse : " + type + "\n";
		
		for(String answer : possibleAnswer)
			ret += answer + "\n";
		return ret;
	}
}
