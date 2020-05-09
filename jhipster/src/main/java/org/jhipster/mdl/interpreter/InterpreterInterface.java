package org.jhipster.mdl.interpreter;

import java.util.Optional;

import org.jhipster.mdl.domain.CurrentStep;
import org.jhipster.mdl.domain.MdlUser;
import org.jhipster.mdl.domain.WorkflowInstance;
import org.jhipster.mdl.domain.WorkflowInstanceState;
import org.jhipster.mdl.repository.CurrentStepRepository;
import org.jhipster.mdl.workflow.to_transfert_data.StepDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xtext.metadoodle.interpreter.Implementation.InterpreterImpl;
import org.xtext.metadoodle.interpreter.Implementation.UserInteraction;
import org.xtext.metadoodle.interpreter.Interface.ID;
import org.xtext.metadoodle.interpreter.Interface.Interpreter;
import org.xtext.metadoodle.interpreter.Interface.WorkflowStep;

public class InterpreterInterface {
	private static final Logger log = LoggerFactory.getLogger(InterpreterInterface.class);

	private static final Interpreter INTERPRETER = new InterpreterImpl();

	public static Optional<StepDTO> getWorkflowStepData(WorkflowInstance workflowInstance, MdlUser mdlUser,
			CurrentStepRepository currentStepRepository, boolean endOfStep) {
		log.debug("Resquest WorkflowStepData with value {}", endOfStep);

		WorkflowExecutionStateImpl workflowExecutionStateImpl = new WorkflowExecutionStateImpl(
				workflowInstance.getState(), mdlUser, endOfStep);
		
		String wfModel = workflowInstance.getWfModel().getBody();

//		String wfModel = "nomDuWF \"desc\""
//				+ " {StepName:Etape_1 Comment:\"Le commentaire\" Survey {QuestionTitle: Q1 QuestionType: CheckBox PossibleAnswers: \"rep_1\" \"rep_2\"} Synchro 02/07/20 false false 0 }"
//				+ " {StepName:Etape_2 Comment:\"Nouvelle etape\" Survey {QuestionTitle: Q2 QuestionType: CheckBox PossibleAnswers: \"rep_3\" \"rep_4\"} Synchro 02/07/20 false false 0 }";

		WorkflowStep wfStep = INTERPRETER.getStep(wfModel, workflowExecutionStateImpl);

		log.debug("User Interactions {}", wfStep.getUserInteractions());

		Optional<CurrentStep> optCurrentStep = workflowInstance.getState().findCurrentStepContainingMdlUser(mdlUser);
		if (!optCurrentStep.isPresent()) {
			log.debug("Current Step not found for MdlUser {}", mdlUser);
			return Optional.empty();
		}
		
		CurrentStep currentStep = optCurrentStep.get();
		Optional<ID> nextStepIdent = wfStep.getIDOfNextStep();
		String nextStepID = currentStep.getStepIdent();
		//String nextStepIdent = "test";

		// if (!currentStep.getStepIdent().equals(nextStepIdent)) {
		if (endOfStep && nextStepIdent.isPresent() && nextStepIdent.get() != null) {
			nextStepID = nextStepIdent.get().getID();
			WorkflowInstanceState workflowInstanceState = workflowInstance.getState();

			currentStep.removeUsers(mdlUser);
			CurrentStep newCurrentStep = workflowInstanceState.putMdlUserInRightCurrentStep(mdlUser, nextStepIdent.get().getID());

			if (!currentStep.equals(newCurrentStep)) {
				currentStepRepository.saveAndFlush(newCurrentStep);
			}
			
		}
		
		StepDTOFactoryImpl stepDTOFactoryImpl = new StepDTOFactoryImpl(nextStepID);
		
		int index = 0;
		for (UserInteraction interaction : wfStep.getUserInteractions()) {
			stepDTOFactoryImpl.addUserInteraction(interaction, String.valueOf(index));
			index++;
		}
		
		StepDTO stepDTO  = stepDTOFactoryImpl.build();
		
		return Optional.of(stepDTO);
	}
}
