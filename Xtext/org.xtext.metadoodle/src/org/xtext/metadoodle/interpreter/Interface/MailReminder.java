package org.xtext.metadoodle.interpreter.Interface;

import java.util.Optional;

public interface MailReminder {
	
	/**
	 * Retourne la prochaine date pour envoyer les mails de rappel.
	 * @return une date d'envoie optionnel
	 */
	public Optional<String> getNextDateToSend();
	
	/**
	 * Cette methode retourne l'object des mails à envoyer.
	 * @return
	 */
	public String getObject();
	
	/**
	 * Retourne le corps du mail à envoyer
	 * @return corps du mail
	 */
	public String getBody();
}
