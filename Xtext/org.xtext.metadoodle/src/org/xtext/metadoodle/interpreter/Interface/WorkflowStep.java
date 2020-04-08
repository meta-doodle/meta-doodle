package org.xtext.metadoodle.interpreter.Interface;

import java.util.List;
import java.util.Optional;

import org.xtext.metadoodle.interpreter.Implementation.UserInteraction;

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
	
	@Override
	public String toString();
}
