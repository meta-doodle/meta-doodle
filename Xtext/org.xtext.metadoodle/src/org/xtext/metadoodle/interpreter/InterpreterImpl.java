package org.xtext.metadoodle.interpreter;

import java.io.InputStream;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.xtext.metadoodle.MDLStandaloneSetup;

import org.xtext.metadoodle.mDL.impl.WorkflowImpl;

import com.google.inject.Injector;

/**
 * Cette classe permet de traiter un workflow(wf) sous forme de String.
 * 
 * @version 0.1
 */
public class InterpreterImpl implements Interpreter {
	/**
	 * A définir
	 */
	ResourceSet resSet;
	Injector injector;

	/**
	 * Le logger.
	 */
	private final Logger LOG = Logger.getLogger(InterpreterImpl.class.getName());

	/**
	 * Le constructeur.
	 */
	public InterpreterImpl() {
		injector = new MDLStandaloneSetup().createInjectorAndDoEMFRegistration();
		// resSet = injector.getInstance(ResourceSet.class);
	}

	@Override
	public WorkflowStep getStep(String wfString, WorkflowExecutionState wes) {
		LOG.info(">> " + wfString);

		// Resource r = resSet.getResource(URI.createURI("wfInstance.mdl"), true);
		final XtextResourceSet rs = injector.<XtextResourceSet>getInstance(XtextResourceSet.class);
		final IResourceFactory factory = injector.<IResourceFactory>getInstance(IResourceFactory.class);
		Resource _createResource = factory.createResource(URI.createURI("internal.test"));
		final XtextResource r = ((XtextResource) _createResource);
		rs.getResources().add(r);

		// Transformation du String en InputString.
		InputStream in = new StringInputStream(wfString);

		LOG.info("<< init : >> load");
		try {
			// Chargement du wf.
			r.load(in, null);
		} catch (Exception e) {
			e.printStackTrace();
		}

		LOG.info("<< load");
		// TODO : créer le workflowStep.

		EcoreUtil.resolveAll(r);
		final EObject root = r.getParseResult().getRootASTElement();
		final WorkflowImpl toplevel = ((WorkflowImpl) root);
		
		// TODO Passer de workflowImpl (généré par xtext) à workflowStep (géré par nous).
		String nameWF = toplevel.getName();
		String desc = toplevel.getDesc();
		
		
		WorkflowStep wfStep = new WorkflowStepImpl(new IDImpl(nameWF), desc);
		
		
		
		return wfStep;
	}

	public static void main(String args[]) {
		Interpreter i = new InterpreterImpl();

		String wfInstance = "nomDuWF \"desc\" {StepName:Etape_1 Comment:\"Le commentaire\" Survey {QuestionTitle: Q1 QuestionType: CheckBox PossibleAnswers: \"rep_1\" \"rep_2\"} Synchro 01/01/20 false false 0 }";

		WorkflowStep ws = i.getStep(wfInstance, null);

		System.out.println(">>> " + ws);
	}
}
