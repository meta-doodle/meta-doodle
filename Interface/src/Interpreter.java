
public interface Interpreter {
	/**
	 * Cette méthde retourne l'étape en cours du Workflow (wf) passé en paramètre.
	 * Si les conditions de fin d'étape sont respectées, l'étape retournée sera l'étape 
	 * suivante (par rapport à stepID).
	 * @param wf L'instance du workflow à traiter.
	 * @param curStepID Le numéro de l'étape en cours.
	 * @param responseRate Le pourcentage de réponse à l'étape en cours.
	 * 			Peut ne pas avoir d'utilitée.
	 * @return L'étape en cours à afficher.
	 */
	public Step getStep(String wf, int curStepID, float responseRate);
}
