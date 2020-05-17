package org.xtext.metadoodle.interpreter.Implementation;

import java.util.Objects;
import java.util.Optional;

import org.xtext.metadoodle.interpreter.Interface.MailReminder;
import org.xtext.metadoodle.interpreter.Interface.StepDTO;
import org.xtext.metadoodle.interpreter.Interface.StepDTOFactory;
import org.xtext.metadoodle.mDL.WorkflowStepLan;

public class StepDTOFactoryImpl implements StepDTOFactory{

	private StepDTOImpl step;
	private MailReminderImpl mail;
	private String currentStepID;
	
	public StepDTOFactoryImpl(StepDTOImpl step, MailReminderImpl mail, String id){
		Objects.requireNonNull(step);
		Objects.requireNonNull(id);
		
		this.step = step;
		this.mail = mail;
		this.currentStepID = id;
	}
	
	public StepDTOFactoryImpl(WorkflowStepLan workflowStepLan) {
		step = new StepDTOImpl(workflowStepLan);
		if(workflowStepLan.getReminders() != null) {
			mail = new MailReminderImpl(workflowStepLan.getReminders());
		} else {
			mail = null;
		}
		currentStepID = workflowStepLan.getName();
	}
	
	@Override
	public Optional<MailReminder> getMailReminder() {
		if(this.mail == null) {
			return Optional.empty();
		}
		return Optional.of(this.mail);
	}

	@Override
	public String getCurrentStepID() {
		return this.currentStepID.toString();
	}

	@Override
	public StepDTO build() {
		return this.step;
	}

	@Override
	public void addResponses(String questionID, String response) {
		Objects.requireNonNull(questionID);
		Objects.requireNonNull(response);
		
		this.step.getUserInteractionDTO(questionID).setResponse(response);
	}

	@Override
	public Optional<String> getError() {
		return Optional.empty();
	}
}
