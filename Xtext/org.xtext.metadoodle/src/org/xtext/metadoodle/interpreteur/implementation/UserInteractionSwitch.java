package org.xtext.metadoodle.interpreteur.implementation;

import org.xtext.metadoodle.interpreter.Interface.StepDTO;
import org.xtext.metadoodle.mDL.CalendarLan;
import org.xtext.metadoodle.mDL.FileUploadLan;
import org.xtext.metadoodle.mDL.QuestionLan;
import org.xtext.metadoodle.mDL.SurveyLan;
import org.xtext.metadoodle.mDL.util.MDLSwitch;

public class UserInteractionSwitch extends MDLSwitch<StepDTOImpl> {

	private StepDTOImpl stepdto;

	public UserInteractionSwitch(StepDTOImpl stepdto) {
		this.stepdto = stepdto;
	}
	
	@Override
	public StepDTOImpl caseSurveyLan(SurveyLan survey) {
		for (QuestionLan question : survey.getQuestions()) {
			caseQuestionLan(question);
		}
		return stepdto;
	}

	@Override
	public StepDTOImpl caseQuestionLan(QuestionLan question) {
		UserInteractionType uitype = UserInteractionType.getUserInteractionType(question.getType());
		String id = "Q_"+stepdto.getUserInteractionDTOs().size();
		UserInteractionDTOImpl uidto = stepdto.addUserInteraction(question.getQuestion(), uitype, id);
		if (question.getResponses()!= null) {
			for (String answer : question.getResponses()) {
				uidto.addPossibleAnswer(answer);
			}
		}
		return stepdto;
	}
	
	@Override
	public StepDTOImpl caseCalendarLan(CalendarLan calendar) {
		UserInteractionType uitype = UserInteractionType.CALENDAR;
		String id = "C_"+stepdto.getUserInteractionDTOs().size();
		UserInteractionDTOImpl uidto = stepdto.addUserInteraction("choisisez une date", uitype, id);
		uidto.addOption("dateBegin", calendar.getStart());
		uidto.addOption("dateEnd", calendar.getEnd());
		if (calendar.getAccuracy()!= null) {
			uidto.addOption("accuracy", calendar.getAccuracy());
		}
		return stepdto;
	}
	
	@Override
	public StepDTOImpl caseFileUploadLan(FileUploadLan file) {
		UserInteractionType uitype = UserInteractionType.FILE;
		String id = "F_"+stepdto.getUserInteractionDTOs().size();
		UserInteractionDTOImpl uidto = stepdto.addUserInteraction("upload fichier", uitype, id);
		if (file.getMimeTypes()!= null) {
			for (String answer : file.getMimeTypes()) {
				uidto.addPossibleAnswer(answer);
			}
		}
		else {
			//TODO error
		}
		return stepdto;
	}

}
