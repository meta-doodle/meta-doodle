package org.xtext.metadoodle.interpreter.Interface;

import java.util.Optional;

public interface MailReminder {
	
	/**
	 * Retourne la prochaine date pour envoyer les mails de rappelle.
	 * @return La date.
	 */
	public Optional<String> getNextDateToSend();
	
	/**
	 * Cette methode retourne l'object des mails à envoyer.
	 * @return
	 */
	public String getObject();
	
	/**
	 * 
	 * @return
	 */
	public String getBody();
	

	public void addDate(String date);
}
