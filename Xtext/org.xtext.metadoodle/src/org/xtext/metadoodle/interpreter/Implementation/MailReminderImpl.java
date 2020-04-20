package org.xtext.metadoodle.interpreter.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.xtext.metadoodle.interpreter.Interface.MailReminder;

public class MailReminderImpl implements MailReminder {

	private List<String> dates;
	private String objectMail, bodyMail;
	
	public MailReminderImpl(String object, String body) {
		this.objectMail = object;
		this.bodyMail = body;
		this.dates = new ArrayList<>();
	}
	
	@Override
	public Optional<String> getNextDateToSend() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getObject() {
		return this.objectMail;
	}

	@Override
	public String getBody() {
		return this.bodyMail;
	}

	/**
	 * ajoute une date dans la liste des dates de mails de rappel
	 * @param date
	 */
	public void addDate(String date) {
		Objects.requireNonNull(date);
		this.dates.add(date);
	}
}
