
public interface Reminder {
	
	/**
	 * Retourne la prochaine date pour envoyer les mails de rappelle.
	 * @return La date.
	 */
	public String getNextDateToSend();
	
	/**
	 * Cette methode retourne l'object des mails à envoyer.
	 * @return
	 */
	public String getObject();
	
	/**
	 * 
	 * @return
	 */
	public String getBody();
}
