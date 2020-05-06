package org.xtext.metadoodle.interpreter.Interface;

import java.util.List;

public interface Answer {
	
	public String getUserID();
	public String getStepID();
	/**
	 * Cette méthode retourne la réponse de l'utilisateur à la question 
	 * reqID.
	 * 
	 * @param reqID
	 * @return
	 */
	public List<String> getAnswer(String reqID);
}
