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
		Resource r = resSet.getResource(URI.createURI(wf), true);
		
		try {
			r.load(null);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// TODO : créer le workflowStep.
		
		return null;
	}
	
	public static void main(String args[]) {
		Interpreter i = new InterpreterImpl();
		// TODO pour les testes
		//WorkflowStep ws = getStep()
	}

}
