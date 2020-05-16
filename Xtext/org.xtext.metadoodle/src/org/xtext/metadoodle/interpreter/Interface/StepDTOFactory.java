package org.xtext.metadoodle.interpreter.Interface;

import java.util.Optional;

/**
 * Cette classe permet de donner au back ce qu'il à besoin 
 * (mailreminder et curStepID) et de retourner au front l'objet
 * retourné par la méthode Build.
 * 
 * @version 2.1 (nouveau WorkflowStep)
 */
public interface StepDTOFactory {
	
	public Optional<MailReminder> getMailReminder();
	
	public String getCurrentStepID();
	
	public StepDTO Build();
	
	/**
	 * Permet d'ajouter des réponses aux question déjà répondu.
	 * @param questionID
	 * @param response
	 */
	public void addResponses(String questionID, String response);
	
	public Optional<String> getError();
}
