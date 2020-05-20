package org.xtext.metadoodle.interpreter.Implementation;

import java.util.Optional;
import java.util.function.BiFunction;

import org.xtext.metadoodle.mDL.UserInteractionLan;
import org.xtext.metadoodle.mDL.WorkflowLan;
import org.xtext.metadoodle.mDL.WorkflowStepLan;

public class QuestionTitleGetter implements BiFunction<String, String, Optional<String>>{
	
	private WorkflowLan wfLan;

	public QuestionTitleGetter(WorkflowLan wfLan) {
		this.wfLan = wfLan;
	}
	
	private Optional<WorkflowStepLan> findStepByName(String name){
		for (WorkflowStepLan workflowStepLan : wfLan.getSteps()) {
			if(workflowStepLan.getName().equals(name)) {
				return Optional.of(workflowStepLan);
			}
		}
		return Optional.empty();
	}
	
	private Optional<String> findQuestionById(String questionID, WorkflowStepLan workflowStepLan){
		UserInteractionSwitchBuilder userInteractionBuilder = new UserInteractionSwitchBuilder();
		for (UserInteractionLan userInteraction : workflowStepLan.getUserInteraction()) {
			userInteractionBuilder.doSwitch(userInteraction);
		}
		for (UserInteractionDTOImpl userInteractionDTOImpl : userInteractionBuilder.getList()) {
			if(userInteractionDTOImpl.getQuestionID().equals(questionID)) {
				return Optional.of(userInteractionDTOImpl.getTitle());
			}
		}
		return Optional.empty();
	}

	@Override
	public Optional<String> apply(String stepID, String questionID) {
		Optional<WorkflowStepLan> step = findStepByName(stepID);
		if(step.isPresent()) {
			return findQuestionById(questionID, step.get());
		}
		return Optional.empty();
	}

}
