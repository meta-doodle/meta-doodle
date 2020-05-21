package org.xtext.metadoodle.interpreter.Interface;

import java.util.List;
import java.util.Optional;

/**
 * Cette classe permet d'accéder aux informations 
 * générale sur le workflow.
 * @version 1.0
 */
public interface WorkflowInstanceData {
//	/**
//	 * Retourne le nom du workflow.
//	 * @return
//	 */
//	public String getName();
//	/**
//	 * Retourne la description du workflow.
//	 * @return
//	 */
//	public String getDescription();
	/**
	 * Retourne l'id de la première étape.
	 * @return
	 */
	public String getIDFirstStep();
	/**
	 * Retourne La liste des roles utilisé 
	 * dans le WF.
	 * @return 
	 */
	public List<String> getRoles();
	
	public Optional<String> getQuestionTitle(String stepID, String questionID);
}
