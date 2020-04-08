package org.xtext.metadoodle.interpreter.Implementation;

import org.xtext.metadoodle.interpreter.Interface.ID;
import org.xtext.metadoodle.interpreter.Interface.MailReminder;

import java.util.Objects;

public abstract class UserInteraction {
	private ID id;
	private String comment;
	private InteractionType it;
	private boolean hasReminder;
	private MailReminder mail;
	
	public UserInteraction(ID id, String comment, InteractionType it) {
		this.id = id;
		this.comment = comment;
		this.it = it;
		this.hasReminder = false;
	}
	
	public ID getStepID() {
		return this.id;
	}
	
	public String getComment() {
		return this.comment;
	}
	
	public InteractionType getType() {
		return this.it;
	}

	/**
	 * cette méthode retourne true s'il y a un rappel.
	 * @return
	 */
	public boolean hasReminder() {
		return hasReminder;
	}
	
	/**
	 * Retourne l'object Reminder qui s'occupe des rappels.
	 * @return
	 */
	public MailReminder getReminder() {
		return this.mail;
	}
	
	/**
	 * Cette méthode permet d'ajouter un mail de rappel.
	 * C'est elle qui change le hasReminder à vrai.
	 * @param mail Le corps du mail à envoyer ainsi que les dates d'envoi.
	 */
	public void setReminder(MailReminder mail) {
		Objects.requireNonNull(mail);
		this.mail = mail;
	}
	
	/**
	 * Cette méthode retourne une description précise du l'instance de l'object.
	 * @return
	 */
	protected abstract String more();
	
	@Override
	public String toString() {
		return "Nom de l'étape : " + this.id + " | " + this.comment + 
				"\nType : " + this.it + " :\n" + more();
	}
}
