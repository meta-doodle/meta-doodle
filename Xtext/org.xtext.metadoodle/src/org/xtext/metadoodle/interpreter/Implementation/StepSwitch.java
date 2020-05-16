package org.xtext.metadoodle.interpreter.Implementation;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.xtext.metadoodle.interpreter.Interface.WorkflowExecutionState;
import org.xtext.metadoodle.mDL.AbrstractQuest;
import org.xtext.metadoodle.mDL.GotoQuestionLan;
import org.xtext.metadoodle.mDL.SurveyLan;
import org.xtext.metadoodle.mDL.WorkflowStepLan;
import org.xtext.metadoodle.mDL.util.MDLSwitch;

public class StepSwitch extends MDLSwitch<Optional<WorkflowStepLan>> {
	private WorkflowExecutionState wes;
	
	public StepSwitch(WorkflowExecutionState wes) {
		this.wes = wes;
	}
	
	@Override
	public Optional<WorkflowStepLan> caseSurveyLan(SurveyLan object) {
		Optional<WorkflowStepLan> res;
		
		for(AbrstractQuest q : object.getQuestions()) {
			res = doSwitch(q);
			
			if(res.isPresent()) {
				return res;
			}
		}
		return Optional.empty();
	}
	
	@Override
	public Optional<WorkflowStepLan> caseGotoQuestionLan(GotoQuestionLan object) {
		object.get
		return null;
	}
	
	@Override
	public Optional<WorkflowStepLan> defaultCase(EObject object) {
		return Optional.empty();
	}
}
