
public interface Step {
	/**
	 * Cette méthode retourne le numéro de l'étape en cours.
	 * @return Le numéro de l'étape en cours.
	 */
	public int getId();
	
	/**
	 * Cette métode retourne le commentaire (ou titre) de l'étape.
	 * @return Le commentaire de l'étape.
	 */
	public String getComment();
	
	/**
	 * 
	 * @return
	 */
	public UserInput getUserInput();
	
	
	
}
