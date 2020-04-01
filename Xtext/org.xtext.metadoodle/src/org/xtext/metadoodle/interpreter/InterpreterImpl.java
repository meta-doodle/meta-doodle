package org.xtext.metadoodle.interpreter;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.xtext.metadoodle.MDLStandaloneSetup;

import com.google.inject.Injector;

public class InterpreterImpl implements Interpreter{
	Injector injector;
	ResourceSet resSet;

	public InterpreterImpl() {
		injector = new MDLStandaloneSetup().createInjectorAndDoEMFRegistration();
		resSet = injector.getInstance(ResourceSet.class);
	}
	
	@Override
	public WorkflowStep getStep(String wf, WorkflowExecutionState wes) {
		Resource r = resSet.getResource(URI.createURI("wfInstance.mdl"), true);

		System.out.println("ok");
		try {
			r.load(null);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("ok");
		// TODO : créer le workflowStep.
		
		return null;
	}
	
	public static void main(String args[]) {
		Interpreter i = new InterpreterImpl();
		
		String wfInstance = "nomDuWF \"desc\" {StepName:Etape_1 Comment:\"Le commentaire\" Survey {QuestionTitle: Q1 QuestionType: CheckBox PossibleAnswers: \"rep_1\" \"rep_2\"} Synchro 01/01/20 false false 0 }";
		
		WorkflowStep ws = i.getStep(wfInstance, null);
	}

}
