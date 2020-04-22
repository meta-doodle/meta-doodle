package org.xtext.metadoodle.interpreter.Interface;

public interface WorkflowInstanceData {
	/**
	 * Retourne le nom du workflow.
	 * @return
	 */
	public String getName();
	/**
	 * Retourne la description du workflow.
	 * @return
	 */
	public String getDescription();
	/**
	 * Retourne l'id de la première étape.
	 * @return
	 */
	public String getIDFirstStep();
}
