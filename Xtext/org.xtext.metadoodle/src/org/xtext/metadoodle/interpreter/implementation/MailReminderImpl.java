package org.xtext.metadoodle.interpreter.implementation;

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
	
	public MailReminderImpl(String object, String body, List<String> dates) {
		this.objectMail = object;
		this.bodyMail = body;
		this.dates = dates;
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


	@Override
	public List<String> getDateToSend() {
		return this.dates;
	}
	
	@Override
	public String toString() {
		String mail = "";
		mail+= "Object : "+ this.objectMail +"\nBody : "+ this.bodyMail + "\n [";
		for (String date : dates) {
			mail+= " "+ date ;
		}
		mail+="]";
		return mail;
	}

}
