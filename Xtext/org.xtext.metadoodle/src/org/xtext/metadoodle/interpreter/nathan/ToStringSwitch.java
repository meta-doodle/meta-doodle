package org.xtext.metadoodle.interpreter.nathan;

import org.xtext.metadoodle.mDL.AnswerTypeLan;
import org.xtext.metadoodle.mDL.CalendarLan;
import org.xtext.metadoodle.mDL.FileUploadLan;
import org.xtext.metadoodle.mDL.MailReminderLan;
import org.xtext.metadoodle.mDL.QuestionLan;
import org.xtext.metadoodle.mDL.SurveyLan;
import org.xtext.metadoodle.mDL.SynchroLan;
import org.xtext.metadoodle.mDL.UserInteractionLan;
import org.xtext.metadoodle.mDL.WorkflowLan;
import org.xtext.metadoodle.mDL.WorkflowStepLan;
import org.xtext.metadoodle.mDL.util.MDLSwitch;

public class ToStringSwitch extends MDLSwitch<String> {
	
	@Override
	public String caseAnswerTypeLan(AnswerTypeLan object) {
		return "AnswerType=" + object.getType();
	}

	@Override
	public String caseCalendarLan(CalendarLan object) {
		return "Calendar{ accuracy=" + object.getAccuracy() + ", start=" + object.getStart() + ", end="
				+ object.getEnd() + "}";
	}

	@Override
	public String caseFileUploadLan(FileUploadLan object) {
		return "FileUpload" + object.getMimeTypes();
	}

	@Override
	public String caseMailReminderLan(MailReminderLan object) {
		if (object == null) {
			return "MailReminder=null";
		}
		return "MailReminder{ objet=" + object.getObject() + ", body=" + object.getBody() + ", dates="
				+ object.getDateToSend() + "}";
	}

	@Override
	public String caseQuestionLan(QuestionLan object) {
		return "Question{ name=" + object.getName() + ", type=" + object.getType().getType() + ", reponsesPossibles="
				+ object.getResponses() + "}";
	}

	@Override
	public String caseSurveyLan(SurveyLan object) {
		String str = "Survey{\n";
		for (QuestionLan questionLan : object.getQuestions()) {
			str += "\t" + caseQuestionLan(questionLan) + "\n";
		}
		str += "}";
		return str;
	}

	@Override
	public String caseSynchroLan(SynchroLan object) {
		if (object == null) {
			return "Synchro=null";
		}
		return "Synchro{ date=" + object.getEndStepDate() + ", waitOthers=" + object.getWaitOtherUsers()
				+ ", pourcentCompletion=" + object.getPercentageCompletionUse() + ", pourcentCompletionValue="
				+ object.getPercentageCompletion() + "}";
	}
	
	@Override
	public String caseUserInteractionLan(UserInteractionLan object) {
		return doSwitch(object).replaceAll("\n", "\n\t");
	}

	@Override
	public String caseWorkflowStepLan(WorkflowStepLan object) {
		String str = "WorkflowStep{\n";
		str += "\tname=" + object.getName() + "\n";
		str += "\tcomment=" + object.getComment() + "\n";

		str += "\t" + caseMailReminderLan(object.getReminders()) + "\n";

		str += "\t" + caseSynchroLan(object.getSynchro()) + "\n";

		for (UserInteractionLan userInteractionLan : object.getUserInteraction()) {
			str += "\t" + caseUserInteractionLan(userInteractionLan) + "\n";
		}
		str += "\n}";
		return str;
	}

	@Override
	public String caseWorkflowLan(WorkflowLan object) {
		String str = "Workflow{\n";
		str += "\tname=" + object.getName() + "\n";
		str += "\tdescr=" + object.getDesc() + "\n";
		for (WorkflowStepLan workflowStepLan : object.getSteps()) {
			str += "\t" + caseWorkflowStepLan(workflowStepLan).replaceAll("\n", "\n\t") + "\n";
		}
		str += "}";
		return str;
	}
}
