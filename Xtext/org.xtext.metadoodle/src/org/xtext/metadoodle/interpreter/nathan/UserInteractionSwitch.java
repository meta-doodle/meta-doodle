package org.xtext.metadoodle.interpreter.nathan;

import java.util.ArrayList;
import java.util.List;

import org.xtext.metadoodle.mDL.CalendarLan;
import org.xtext.metadoodle.mDL.FileUploadLan;
import org.xtext.metadoodle.mDL.QuestionLan;
import org.xtext.metadoodle.mDL.SurveyLan;
import org.xtext.metadoodle.mDL.util.MDLSwitch;

class UserInteractionSwitch extends MDLSwitch<StepDTO> {
	@Override
	public StepDTO caseSurveyLan(SurveyLan object) {
		StepImpl stepDTO = new StepImpl();
		for (QuestionLan questionLan : object.getQuestions()) {
			UserInteractionImpl userInteraction = new UserInteractionImpl(questionLan);
			stepDTO.userInteractionDTOs.add(userInteraction);
		}
		return stepDTO;
	}
	
	@Override
	public StepDTO caseCalendarLan(CalendarLan object) {
		List<String> options = new ArrayList<>();
		options.add(object.getStart());
		options.add(object.getEnd());
		
		UserInteractionImpl userInteraction = new UserInteractionImpl("Choisir une date :", options, "CALENDAR");
		return new StepImpl(userInteraction);
	}
	
	@Override
	public StepDTO caseFileUploadLan(FileUploadLan object) {
		UserInteractionImpl userInteraction = new UserInteractionImpl("Upload file :", object.getMimeTypes() , "FILE");
		return new StepImpl(userInteraction);
	}
}
