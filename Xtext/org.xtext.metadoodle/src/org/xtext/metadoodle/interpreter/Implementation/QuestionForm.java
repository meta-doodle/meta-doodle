package org.xtext.metadoodle.interpreter.Implementation;

import java.util.ArrayList;
import java.util.List;

public class QuestionForm {
	
	private String title;
	private AnswerType type;
	private List<String> possibleAnswer;
	
	public QuestionForm(String title, AnswerType at) {
		this(title, at, new ArrayList<>());
	}
	
	public QuestionForm(String title, AnswerType at, List<String> possibleAnswer) {
		this.title = title;
		this.type = at;
		this.possibleAnswer = possibleAnswer;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public AnswerType getAnswerType() {
		return this.type;
	}
	
	public List<String> getPossibleAnswer(){
		return this.possibleAnswer; // TODO rendre immutable.
	}
}
