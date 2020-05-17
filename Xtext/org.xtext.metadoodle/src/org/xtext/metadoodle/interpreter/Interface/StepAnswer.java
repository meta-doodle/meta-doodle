package org.xtext.metadoodle.interpreter.Interface;

public interface StepAnswer {
	
//	public String getUserID();
	public String getStepID();
	/**
	 * Cette méthode retourne la réponse de l'utilisateur à la question 
	 * reqID.
	 * 
	 * @param reqID
	 * @return
	 */
	public String getAnswer(String reqID);
}
