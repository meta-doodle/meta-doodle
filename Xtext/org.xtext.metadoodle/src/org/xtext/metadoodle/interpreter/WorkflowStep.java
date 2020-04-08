package org.xtext.metadoodle.interpreter;

import java.util.List;
import java.util.Optional;

/**
 * Cette classe gère l'étape d'une instance de workflow.
 * 
 * @version 1.0
 */
public interface WorkflowStep {
	/**
	 * Cette méthode retourne l'ID de l'étape en cours.
	 * @return L'ID de l'étape en cours.
	 */
	public ID getId();
	
	/**
	 * This method return the list of ID of next step.
	 * @return
	 */
	public List<ID> getIDOfNextStep();
	
	/**
	 * Cette métode retourne le commentaire (ou titre) de l'étape.
	 * @return Le commentaire de l'étape.
	 */
	public Optional<String> getComment();
	
	/**
	 * Cette méthode permet d'ajouter des UserInteraction.
	 * @param interaction L'interaction à ajouter.
	 */
	public void addUserInteraction(UserInteraction interaction);
	
	/**
	 * Donne l'action correspondant à l'étape.
	 * @return
	 */
	public List<UserInteraction> getUserInteractions();
	
	/**
	 * cette méthode retourne true s'il y a un rappel.
	 * @return
	 */
	public boolean hasReminder();
	
	/**
	 * Retourne l'object Reminder qui s'occupe des rappels.
	 * @return
	 */
	public MailReminder getReminder();
	
	/**
	 * Cette méthode permet d'ajouter un mail de rappel.
	 * C'est elle qui change le hasReminder à vrai.
	 * @param mail Le corps du mail à envoyer ainsi que les dates d'envoi.
	 */
	public void setReminder(MailReminder mail);
	
	@Override
	public String toString();
}
