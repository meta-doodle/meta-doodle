package org.xtext.metadoodle.interpreter.Interface;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.xtext.metadoodle.interpreter.Implementation.UserInteraction;

/**
 * Cette classe gère l'étape d'une instance de workflow.
 * 
 * @version 1.0
 */
public interface WorkflowStep extends Serializable{
	/**
	 * Cette méthode retourne l'ID de l'étape en cours.
	 * @return L'ID de l'étape en cours.
	 */
	public String getId();
	
	/**
	 * This method return the ID of the next step.
	 * @return
	 */
	public Optional<ID> getIDOfNextStep();
	
	/**
	 * Cette métode retourne le commentaire (ou titre) de l'étape.
	 * @return Le commentaire de l'étape.
	 */
	public Optional<String> getComment();
	
	/**
	 * Donne l'action correspondant à l'étape.
	 * @return
	 */
	public List<UserInteraction> getUserInteractions();
	
	@Override
	public String toString();
}
