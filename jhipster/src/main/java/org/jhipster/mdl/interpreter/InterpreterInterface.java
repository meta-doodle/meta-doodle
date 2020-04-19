package org.jhipster.mdl.interpreter;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.jhipster.mdl.domain.CurrentStep;
import org.jhipster.mdl.domain.MdlUser;
import org.jhipster.mdl.domain.WorkflowInstance;
import org.jhipster.mdl.domain.WorkflowInstanceState;
import org.jhipster.mdl.repository.CurrentStepRepository;
import org.jhipster.mdl.workflow.to_transfert_data.QuestionData;
import org.jhipster.mdl.workflow.to_transfert_data.WorkflowStepData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xtext.metadoodle.interpreter.Implementation.AnswerType;
import org.xtext.metadoodle.interpreter.Implementation.Form;
import org.xtext.metadoodle.interpreter.Implementation.InteractionType;
import org.xtext.metadoodle.interpreter.Implementation.InterpreterImpl;
import org.xtext.metadoodle.interpreter.Implementation.QuestionForm;
import org.xtext.metadoodle.interpreter.Implementation.UserInteraction;
import org.xtext.metadoodle.interpreter.Interface.Interpreter;
import org.xtext.metadoodle.interpreter.Interface.WorkflowStep;

public class InterpreterInterface {
	private static final Logger log = LoggerFactory.getLogger(InterpreterInterface.class);

	private static final Interpreter INTERPRETER = new InterpreterImpl();

	public static Optional<WorkflowStepData> getWorkflowStepData(WorkflowInstance workflowInstance, MdlUser mdlUser, CurrentStepRepository currentStepRepository) {
		WorkflowExecutionStateImpl workflowExecutionStateImpl = new WorkflowExecutionStateImpl(
				workflowInstance.getState(), mdlUser);

		WorkflowStep wfStep = INTERPRETER.getStep(workflowInstance.getWfModel().getBody(), workflowExecutionStateImpl);
		
		Optional<CurrentStep> optCurrentStep = workflowInstance.getState().findCurrentStepContainingMdlUser(mdlUser);
		if (!optCurrentStep.isPresent()) {
			log.debug("Current Step not found for MdlUser {}", mdlUser);
			return Optional.empty();
		}
		CurrentStep currentStep = optCurrentStep.get();
		String nextStepIdent = "nextID"; // TODO revoir result de wfStep.getIDOfNextStep()

		if (!currentStep.getStepIdent().equals(nextStepIdent)) {
			WorkflowInstanceState workflowInstanceState = workflowInstance.getState();
			
			currentStep.removeUsers(mdlUser);
			CurrentStep newCurrentStep = workflowInstanceState.putMdlUserInRightCurrentStep(mdlUser, nextStepIdent);
			
			if (!currentStep.equals(newCurrentStep)) {
				currentStepRepository.saveAndFlush(newCurrentStep);
			}
		}

		List<QuestionData> questionsDatas = new LinkedList<>();

		for (UserInteraction interaction : wfStep.getUserInteractions()) {
			InteractionType type = interaction.getType();
			if (type == InteractionType.FORM) {
				Form form = (Form) interaction;
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
					String title = questionForm.getTitle();
					QuestionData questionData = new QuestionData(returnType, title, questionForm.getPossibleAnswer());
					questionsDatas.add(questionData);
				}
			}
		}

		return Optional.of(new WorkflowStepData(questionsDatas));
	}
}
