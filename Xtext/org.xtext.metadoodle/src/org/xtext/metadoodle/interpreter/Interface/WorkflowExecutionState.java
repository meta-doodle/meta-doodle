package org.xtext.metadoodle.interpreter.Interface;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Cette classe décrit l'état actuel du workflow par rapport à un utilisateur
 * et un workflow.
 * 
 * @version 2
 */
public interface WorkflowExecutionState {
	/**
	 * Cette méthode retourne le nombre total d'utilisateur associé
	 * à ce workflow.
	 * 
	 * @return
	 */
	public int getNumberOfUser();
	
	/**
	 * Cette méthode retourne la liste des id des étapes jusqu'à 
	 * l'étape courrante.
	 * La liste est vide si l'étape en cours est la première étape.
	 * @return
	 */
	public List<String> getPathCurrentStep();
	
	/**
	 * Retourne le nombre de personne qui ont déjà répondu à cette 
	 * etape stepID.
	 * 
	 * @param stepID L'ID de l'étape.
	 * @return Le nombre de personne ayant déjà répondu.
	 */
	public int getNumberAnwers(String stepID);
	
	/**
	 * Cette méthode retourne la réponse de l'utilisateur à la question 
	 * reqID de l'étape stepID. La question doit avoir déjà été répondu 
	 * dans le passé.
	 * 
	 * @param reqID L'id de la question.
	 * @param stepID L'id de l'étape.
	 * @return réponse précédente si présente
	 */
	public Optional<Answer> getPreviousAnswer(String reqID, String stepID);
	
	/**
	 * Cette méthode retourne la valeur décidé grace à une question 
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
	
	/**
	 * Cette méthode retourne vrai si l'utilisateur souhaite modifier l'étape en cours.
	 * @return
	 */
	public boolean wantModifyThisStep();
	
	/**
	 * Retourne une map liant l'id de la date avec sa valeur.
	 * @return
	 */
	public Map<String, String> getDateChoosen();
}
