package org.jhipster.mdl.interpreter;

import org.jhipster.mdl.workflow.to_transfert_data.StepDTO;
import org.xtext.metadoodle.interpreter.Implementation.AnswerType;
import org.xtext.metadoodle.interpreter.Implementation.Form;
import org.xtext.metadoodle.interpreter.Implementation.InteractionType;
import org.xtext.metadoodle.interpreter.Implementation.QuestionForm;
import org.xtext.metadoodle.interpreter.Implementation.UserInteraction;

public class StepDTOFactoryImpl implements StepDTOFactory {

	private String currentStepID;
	private StepDTOImpl stepDTOImpl;

	public StepDTOFactoryImpl(String currentStepID) {
		this.currentStepID = currentStepID;
		this.stepDTOImpl = new StepDTOImpl(currentStepID);
	}

	public StepDTOFactoryImpl addUserInteraction(UserInteraction userInteraction, String questionID) {
		if (userInteraction.getType() == InteractionType.FORM) {
			Form form = (Form) userInteraction;
			for (QuestionForm questionForm : form.getQuestions()) {
				AnswerType questionType = questionForm.getAnswerType();
				String returnType;
				switch (questionType) {
				case CHECKBOX:
					returnType = "CHECKBOX";
					break;
				case FREEANSWER:
					returnType = "TEXTFIELD";
					break;
				case RADIOBUTTON:
					returnType = "RADIOBUTTON";
					break;
				default:
					returnType = "CHECKBOX";
					break;
				}

				UserInteractionDTOImpl userInteractionDTOImpl = new UserInteractionDTOImpl(questionForm.getTitle(),
						questionID, returnType);
				userInteractionDTOImpl.setPossibleAnswers(questionForm.getPossibleAnswer());
				
				stepDTOImpl.addUserInteraction(userInteractionDTOImpl);
			}
		}
		return this;
	}

	@Override
	public String getCurrentStepID() {
		return currentStepID;
	}

	@Override
	public StepDTO build() {
		return stepDTOImpl;
	}

	@Override
	public void addResponse(String questionID, String answer) {
		stepDTOImpl.addResponse(questionID, answer);
	}

}
