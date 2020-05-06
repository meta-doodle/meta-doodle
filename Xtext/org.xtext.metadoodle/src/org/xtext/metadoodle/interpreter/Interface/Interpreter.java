package org.xtext.metadoodle.interpreter.Interface;

public interface Interpreter {
	/**
	 * Cette méthde retourne l'étape en cours du Workflow (wf) passé en paramètre.
	 * Si les conditions de fin d'étape sont respectées, l'étape retournée sera l'étape 
	 * suivante (par rapport à stepID).
	 * @param wf L'instance du workflow à traiter.
	 * @param wfs Les informations consernant l'état d'avancement du wf.
	 * @return L'étape en cours à afficher.
	 */
	public StepDTOFactory getStep(String wf, WorkflowExecutionState wfs);
	/**
	 * Cette méthode retourne les informations générale sur le workflow.
	 * 
	 * @param wfString L'instance du workflow.
	 * @return Un objet contenant le nom et la description du workflow 
	 * ainsi que l'id de la première étape.
	 */
	public WorkflowInstanceData getWorkflowData(String wfString);
}
