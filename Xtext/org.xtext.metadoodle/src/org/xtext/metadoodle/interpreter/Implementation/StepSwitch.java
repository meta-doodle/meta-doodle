package org.xtext.metadoodle.interpreter.Implementation;

import java.util.Optional;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.xtext.metadoodle.interpreter.Interface.WorkflowExecutionState;
import org.xtext.metadoodle.mDL.AbrstractQuest;
import org.xtext.metadoodle.mDL.GotoQuestionLan;
import org.xtext.metadoodle.mDL.PossibleAnswerLan;
import org.xtext.metadoodle.mDL.SurveyLan;
import org.xtext.metadoodle.mDL.WorkflowStepLan;
import org.xtext.metadoodle.mDL.util.MDLSwitch;

public class StepSwitch extends MDLSwitch<Optional<WorkflowStepLan>> {
	
	private static final Logger LOG = Logger.getLogger(StepSwitch.class.getName());
	
	private WorkflowExecutionState wes;
	private String curStepID = null;
	
	public StepSwitch(WorkflowExecutionState wes, String curStepID) {
		this.wes = wes;
		this.curStepID = curStepID;
	}
	
	@Override
	public Optional<WorkflowStepLan> caseSurveyLan(SurveyLan object) {
		LOG.info("Checking Survey Interaction");
		
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
		LOG.info("Checking GotoQuestionLan Interaction");
		EList<PossibleAnswerLan> steps = object.getGotoNextStep();
		
		if(wes.getPreviousAnswer(object.getId(), curStepID).isPresent()) {
			LOG.info("One answer found for Interaction '"+ object.getId()+"'");
			
			String rep = wes.getPreviousAnswer(object.getId(), curStepID).get();
			
			for(PossibleAnswerLan pa : steps) {
				if(pa.getResponse().equals(rep) && pa.getNextStep() != null) {
					return Optional.of(pa.getNextStep());
				}
			}
		} else {
			LOG.info("No answer found for Interaction '"+ object.getId()+"'");
		}
		
		return Optional.empty();
	}
	
	@Override
	public Optional<WorkflowStepLan> defaultCase(EObject object) {
		return Optional.empty();
	}
}