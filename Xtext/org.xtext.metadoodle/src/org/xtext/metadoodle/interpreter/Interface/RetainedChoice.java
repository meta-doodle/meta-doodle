package org.xtext.metadoodle.interpreter.Interface;

public interface RetainedChoice {
	/**
	 * retourne l'id de l'étape regardé
	 * @return ID  
	 */
	public ID getStepID();
	
	/**
	 * retourne l'id de la question regardé
	 * @return ID
	 */
	public ID getRequestID();
	
	/**
	 * retourne le nom associé à this pour être utilisé comme variable
	 * @return nom
	 */
	public String getName();
	
	/**
	 * Retourne la réponse retenue pour la question de l'étape reqID en paramètre
	 * @param reqID
	 * @return Réponse
	 */
	public String getAnswer(ID reqID);
}
