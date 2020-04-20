package org.xtext.metadoodle.interpreter.Interface;

import java.util.Optional;

public interface WorkflowExecutionState {
	/**
	 * Cette méthode retourne le nombre total d'utilisateur associé
	 * à ce workflow.
	 * 
	 * @return
	 */
	public int getNumberOfUser();
	
	/**
	 * Cette méthode retourne l'id de l'étape courrante.
	 * @return
	 */
	public ID getCurrentStepID();
	
	/**
	 * Retourne le nombre de personne qui ont déjà répondu à cette 
	 * etape stepID.
	 * 
	 * @param stepID L'ID de l'étape.
	 * @return Le nombre de personne ayant déjà répondu.
	 */
	public int getNumberAnwers(ID stepID);
	
	/**
	 * Cette méthode retourne la réponse de l'utilisateur à la question 
	 * reqID de l'étape stepID. La question doit avoir déjà été répondu 
	 * dans le passé.
	 * 
	 * @param reqID L'id de la question.
	 * @param stepID L'id de l'étape.
	 * @return 
	 */
	public Optional<Answer> getPreviousAnswer(ID reqID, ID stepID);
	
	/**
	 * Cette méthode retourne la valeur désidé grace à une question 
	 * précédente. Celle-ci étant associée à un nom "name".
	 * 
	 * @param name Le nom de la variable.
	 * @return La valeur de la variable.
	 */
	public RetainedChoice getPreviousRetainedChoice(String name);
	
	/**
	 * Cette méthode retourne la précédente réponse de l'utilisateur 
	 * (ou réponses par défault) ce cet utilisateur à la question courrante.
	 * @return
	 */
	public Optional<Answer> getCurrentAnswer();
	
	/**
	 * Méthode permettant de savoir si l'utilisateur a répondu à l'étape en cours.
	 * @return
	 */
	public boolean isStepComplete();
}
