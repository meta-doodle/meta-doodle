package org.xtext.metadoodle.interpreter.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.xtext.metadoodle.mDL.AbrstractQuest;
import org.xtext.metadoodle.mDL.CalendarLan;
import org.xtext.metadoodle.mDL.FileUploadLan;
import org.xtext.metadoodle.mDL.GotoQuestionLan;
import org.xtext.metadoodle.mDL.PossibleAnswerLan;
import org.xtext.metadoodle.mDL.StandardQuestionLan;
import org.xtext.metadoodle.mDL.SurveyLan;
import org.xtext.metadoodle.mDL.util.MDLSwitch;

public class UserInteractionSwitchBuilder extends MDLSwitch<List<UserInteractionDTOImpl>> {

	private List<UserInteractionDTOImpl> list = new ArrayList<>();

	private String getType(String answerType) {
		switch (answerType) {
		case "OpenQuestion":
			return "TEXTFIELD";
		case "CheckBox":
			return "CHECKBOX";
		case "RadioButton":
			return "RADIOBUTTON";
		default:
			return "TEXTFIELD";
		}
	}
	
	public List<UserInteractionDTOImpl> getList() {
		return list;
	}

	@Override
	public List<UserInteractionDTOImpl> defaultCase(EObject object) {
		return list;
	}

	@Override
	public List<UserInteractionDTOImpl> caseStandardQuestionLan(StandardQuestionLan standardQuestionLan) {
		String id = standardQuestionLan.getId();
		String title = standardQuestionLan.getTitle();
		String type = getType(standardQuestionLan.getAnswerType().getType());
		
		UserInteractionDTOImpl userInteractionDTOImpl = new UserInteractionDTOImpl(id, title, type);
		standardQuestionLan.getResponses().forEach(a -> userInteractionDTOImpl.addNewPossibleAnswer(a));
		
		list.add(userInteractionDTOImpl);
		System.out.println("add new interaction : " + title);
		return list;
	}

	@Override
	public List<UserInteractionDTOImpl> caseGotoQuestionLan(GotoQuestionLan gotoQuestionLan) {
		String id = gotoQuestionLan.getId();
		String title = gotoQuestionLan.getTitle();
		String type = "RADIOBUTTON";
		
		UserInteractionDTOImpl userInteractionDTOImpl = new UserInteractionDTOImpl(id, title, type);
		gotoQuestionLan.getGotoNextStep().forEach(a -> userInteractionDTOImpl.addNewPossibleAnswer(a.getResponse()));

		list.add(new UserInteractionDTOImpl(id, title, type));
		return list;
	}

	@Override
	public List<UserInteractionDTOImpl> caseSurveyLan(SurveyLan surveyLan) {
		for (AbrstractQuest abrstractQuest : surveyLan.getQuestions()) {
			doSwitch(abrstractQuest);
		}
		return list;
	}

	@Override
	public List<UserInteractionDTOImpl> caseCalendarLan(CalendarLan calendarLan) {
		String id = calendarLan.getId();
		String title = "Choisissez une date :";
		String type = "CALENDAR";
		list.add(new UserInteractionDTOImpl(id, title, type));
		return list;
	}

	@Override
	public List<UserInteractionDTOImpl> caseFileUploadLan(FileUploadLan fileUploadLan) {
		String id = fileUploadLan.getId();
		String title = "Ajoutez votre fichier :";
		String type = "FILE";
		list.add(new UserInteractionDTOImpl(id, title, type));
		return list;
	}
}
