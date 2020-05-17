package org.xtext.metadoodle.interpreter.implementation;

import java.util.Optional;

import org.xtext.metadoodle.interpreter.Interface.MailReminder;
import org.xtext.metadoodle.interpreter.Interface.StepDTO;
import org.xtext.metadoodle.interpreter.Interface.StepDTOFactory;

public class StepDTOFactoryImpl implements StepDTOFactory {
	private StepDTOImpl stepdto;
	private Optional<MailReminder> mr = Optional.empty();
	
	public StepDTOFactoryImpl(String stepid) {
		stepdto = new StepDTOImpl(stepid);
	}
	
	public StepDTOImpl getStepDTOImpl() {
		return this.stepdto;
	}

	@Override
	public String getCurrentStepID() {
		return stepdto.getStepID();
	}

	@Override
	public StepDTO getStepDTO() {
		return this.stepdto;
	}

	@Override
	public void addResponse(String uiID, String answer) {
		stepdto.addResponse(uiID, answer);
	}
	@Override
	public Optional<MailReminder> getMailReminder() {
		return this.mr;
	}
	
	public void addMailReminder(MailReminderImpl mr) {
		this.mr = Optional.of(mr);
	}
	
	
	@Override
	public String toString() {
		String mail = "";
		if (mr.isPresent()) {
			mail = mr.get().toString();
		}
		return ("StepDTO : " + this.stepdto.toString() + "\nMail Reminder : "+ mail);
	}
}
