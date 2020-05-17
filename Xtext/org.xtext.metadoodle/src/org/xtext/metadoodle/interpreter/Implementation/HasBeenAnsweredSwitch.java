package org.xtext.metadoodle.interpreter.Implementation;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.xtext.metadoodle.interpreter.Interface.WorkflowExecutionState;
import org.xtext.metadoodle.mDL.AbrstractQuest;
import org.xtext.metadoodle.mDL.CalendarLan;
import org.xtext.metadoodle.mDL.FileUploadLan;
import org.xtext.metadoodle.mDL.GotoQuestionLan;
import org.xtext.metadoodle.mDL.StandardQuestionLan;
import org.xtext.metadoodle.mDL.SurveyLan;
import org.xtext.metadoodle.mDL.util.MDLSwitch;

public class HasBeenAnsweredSwitch extends MDLSwitch<Boolean>{
	
	private WorkflowExecutionState wes;
	private String stepID;

	public HasBeenAnsweredSwitch(WorkflowExecutionState wes, String stepID) {
		this.wes = wes;
		this.stepID = stepID;
	}
	
	@Override
	public Boolean defaultCase(EObject object) {
		return true;
	}
	
	@Override
	public Boolean caseCalendarLan(CalendarLan calendarLan) {
		Optional<String> answer = wes.getPreviousAnswer(calendarLan.getId(), stepID);
		return answer.isPresent();
	}
	
	@Override
	public Boolean caseFileUploadLan(FileUploadLan fileUploadLan) {
		Optional<String> answer = wes.getPreviousAnswer(fileUploadLan.getId(), stepID);
		return answer.isPresent();
	}
	
	@Override
	public Boolean caseSurveyLan(SurveyLan surveyLan) {
		for (AbrstractQuest abrstractQuest : surveyLan.getQuestions()) {
			boolean answered = doSwitch(abrstractQuest);
			if(!answered) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public Boolean caseGotoQuestionLan(GotoQuestionLan gotoQuestionLan) {
		Optional<String> answer = wes.getPreviousAnswer(gotoQuestionLan.getId(), stepID);
		return answer.isPresent();
	}
	
	@Override
	public Boolean caseStandardQuestionLan(StandardQuestionLan standardQuestionLan) {
		Optional<String> answer = wes.getPreviousAnswer(standardQuestionLan.getId(), stepID);
		return answer.isPresent();
	}
}
