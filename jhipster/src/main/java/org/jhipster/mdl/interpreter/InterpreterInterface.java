package org.jhipster.mdl.interpreter;

import java.util.Optional;

import org.jhipster.mdl.domain.CurrentStep;
import org.jhipster.mdl.domain.MdlUser;
import org.jhipster.mdl.domain.WorkflowInstanceState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xtext.metadoodle.interpreter.Interface.Interpreter;
import org.xtext.metadoodle.interpreter.Interface.StepDTO;
import org.xtext.metadoodle.interpreter.Interface.StepDTOFactory;
import org.xtext.metadoodle.interpreteur.implementation.InterpreterImpl;

public class InterpreterInterface {
	private static final Logger log = LoggerFactory.getLogger(InterpreterInterface.class);

	private static final Interpreter INTERPRETER = new InterpreterImpl();

	public static Optional<StepDTO> getWorkflowStepData(WorkflowExecutionStateImpl workflowExecutionStateImpl) {
		log.debug("Resquest WorkflowStepData");

		String wfModel = workflowExecutionStateImpl.getWorkflowInstance().getWfModel().getBody();
		WorkflowInstanceState workflowInstanceState = workflowExecutionStateImpl.getWorkflowInstance().getState();
		MdlUser mdlUser = workflowExecutionStateImpl.getMdlUser();

		StepDTOFactory wfStepFactory = INTERPRETER.getStep(wfModel, workflowExecutionStateImpl);
		
		Optional<CurrentStep> optCurrentStep = workflowExecutionStateImpl.findCurrentStep();
		if (!optCurrentStep.isPresent()) {
			log.debug("Current Step not found for MdlUser {}", mdlUser);
			return Optional.empty();
		}
		CurrentStep currentStep = optCurrentStep.get();
		
		String nextStepID = wfStepFactory.getCurrentStepID();

		if (workflowExecutionStateImpl.isEndOfStep() && !currentStep.getStepIdent().equals(nextStepID)) {
			currentStep.removeUsers(mdlUser);
			CurrentStep newCurrentStep = workflowInstanceState.putMdlUserInRightCurrentStep(mdlUser, nextStepID);

			if (!currentStep.equals(newCurrentStep)) {
				workflowExecutionStateImpl.getCurrentStepRepository().saveAndFlush(newCurrentStep);
			}
			
		}
		
		return Optional.of(wfStepFactory.getStepDTO());
	}
	
	public static String getStepIdent(String wfModel) {
		return INTERPRETER.getWorkflowData(wfModel).getIDFirstStep();
	}
}
