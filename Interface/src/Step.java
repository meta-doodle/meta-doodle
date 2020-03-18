/**
 * Cette classe gère l'étape d'une instance de workflow.
 *
 */
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
	 * Donne l'action correspondant à l'étape.
	 * @return
	 */
	public UserInput getUserInput();
	
	/**
	 * cette méthode retourne true s'il y a un rappel.
	 * @return
	 */
	public boolean hasReminder();
	
	/**
	 * Retourne l'object Reminder qui s'occupe des rappels.
	 * @return
	 */
	public Reminder getReminder();
}
