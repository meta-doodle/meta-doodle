package org.xtext.metadoodle.interpreter.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import org.xtext.metadoodle.interpreter.Interface.ID;

public class Form extends UserInteraction {

	private List<QuestionForm> questions;
	static final Logger LOG = Logger.getLogger(Form.class.getName());

	public Form(ID id, String comment, InteractionType it) {
		super(id, comment, it);
		this.questions = new ArrayList<>();
	}

	public List<QuestionForm> getQuestions(){
		return this.questions; // TODO rendre immutable.
	}
	
	public void addQuestion(QuestionForm quest) {
		Objects.requireNonNull(quest);
		//LOG.info(quest.toString());
		this.questions.add(quest);
	}

	@Override
	protected String more() {
		String ret = "Liste des Questions : \n";
		
		for(QuestionForm q : this.questions)
			ret += q + "\n";
		return ret;
	}
}
