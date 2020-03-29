package InterpreterInterfaceReturn;

import java.util.List;
import java.util.Optional;

import InterpreterObjectReturn.UserInteraction;

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
}
