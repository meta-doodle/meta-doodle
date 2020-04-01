package org.xtext.metadoodle.interpreter;

import java.util.List;

public interface Answer {
	
	public ID getUserID();
	public ID getStepID();
	/**
	 * Cette méthode retourne la réponse de l'utilisateur à la question 
	 * reqID.
	 * 
	 * @param reqID
	 * @return
	 */
	public List<String> getAnwer(ID reqID);
}
