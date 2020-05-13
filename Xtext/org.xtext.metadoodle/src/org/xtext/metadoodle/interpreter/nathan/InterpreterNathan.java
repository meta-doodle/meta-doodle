package org.xtext.metadoodle.interpreter.nathan;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.xtext.metadoodle.MDLStandaloneSetup;
import org.xtext.metadoodle.interpreter.Implementation.IDImpl;
import org.xtext.metadoodle.interpreter.Interface.Interpreter;
import org.xtext.metadoodle.interpreter.Interface.WorkflowExecutionState;
import org.xtext.metadoodle.interpreter.Interface.WorkflowInstanceData;
import org.xtext.metadoodle.mDL.SynchroLan;
import org.xtext.metadoodle.mDL.UserInteractionLan;
import org.xtext.metadoodle.mDL.WorkflowLan;
import org.xtext.metadoodle.mDL.WorkflowStepLan;

import com.google.inject.Injector;

class InterpreterNathan implements Interpreter{

	/**
	 * Cette méthode passe le wfString dnas l'interpréteur et retourne la racine de
	 * l'ast.
	 * 
	 * @param wfString Le workflow.
	 * @return La racine de l'AST.
	 */
	private EObject parse(String wfString) {
		Injector injector = new MDLStandaloneSetup().createInjectorAndDoEMFRegistration();
		final XtextResourceSet rs = injector.<XtextResourceSet>getInstance(XtextResourceSet.class);
		final IResourceFactory factory = injector.<IResourceFactory>getInstance(IResourceFactory.class);
		Resource _createResource = factory.createResource(URI.createURI("internal.test"));
		final XtextResource r = ((XtextResource) _createResource);
		rs.getResources().add(r);

		// Transformation du String en InputString.
		InputStream in = new StringInputStream(wfString);

		try {
			// Chargement du wf.
			r.load(in, null);
		} catch (Exception e) {
			e.printStackTrace();
		}

		EcoreUtil.resolveAll(r);
		return r.getParseResult().getRootASTElement();
	}

	private Optional<WorkflowStepLan> findStepByName(String stepID, WorkflowLan workflowLan) {
		for (WorkflowStepLan workflowStepLan : workflowLan.getSteps()) {
			if (workflowStepLan.getName().equals(stepID.toString())) {
				return Optional.of(workflowStepLan);
			}
		}
		return Optional.empty();
	}

	private boolean isStepFinished(WorkflowExecutionState wfs, WorkflowStepLan step) {
		SynchroLan sync = step.getSynchro();
		try {
			Date stepDate = new SimpleDateFormat("dd/MM/yy").parse(sync.getEndStepDate());
			Date curDate = new Date();
			if (stepDate.before(curDate)) { // Si l'étape est passée,
				return true;
			}
		} catch (ParseException e) {
			System.err.println(sync.getEndStepDate());
			e.printStackTrace();
		}

		if (sync.getWaitOtherUsers().equals("true")) {
			if (sync.getPercentageCompletionUse().equals("true")) {
				double percentageCompletion = wfs.getNumberAnwers(new IDImpl(step.getName())) * 100
						/ wfs.getNumberOfUser();
				return wfs.isStepComplete() && percentageCompletion > sync.getPercentageCompletion();
			}
		}

		return false;
	}

	public ExecutionData getStep(String wf, WorkflowExecutionState wfs) {
		EObject o = parse(wf);

		if (!WorkflowLan.class.isInstance(o)) {
			// TODO make error
			System.out.println("cannot parse wf: [" + wf + "]");
			return null;
		}

		WorkflowLan wfl = (WorkflowLan) o;

		Optional<WorkflowStepLan> optStep = findStepByName(wfs.getCurrentStepID().toString(), wfl);
		if (!optStep.isPresent()) {
			// TODO make error
			System.out.println("cannot find stepID " + wfs.getCurrentStepID());
			return null;
		}

		WorkflowStepLan step = optStep.get();
		
		if (isStepFinished(wfs, step)) {
			int index = wfl.getSteps().indexOf(step);
			if (index < wfl.getSteps().size()) {
				step = wfl.getSteps().get(index + 1);
			}
		}

		StepImpl stepImpl = new StepImpl();
		for (UserInteractionLan userInteractionLan : step.getUserInteraction()) {
			
			UserInteractionSwitch userInteractionSwitch = new UserInteractionSwitch();
			
			StepDTO ui = userInteractionSwitch.doSwitch(userInteractionLan);
			
			stepImpl.userInteractionDTOs.addAll(ui.getUserInteraction());
		}

		// TODO add mail reminder
		return new ExecutionDataImpl(new IDImpl(step.getName()), stepImpl);
	}

	public WorkflowInstanceData getWorkflowData(String wfString) {
		EObject o = parse(wfString);
		
		if (!WorkflowLan.class.isInstance(o)) {
			// TODO make error
			System.out.println("cannot parse wf: [" + wfString + "]");
			return null;
		}

		WorkflowLan wf = (WorkflowLan) o;

		return new WorkflowInstanceDataImpl(wf);
	}

	public static void main(String[] args) {
		InterpreterNathan interpreterNathan = new InterpreterNathan();
		WorkflowExecutionState state = new WorkflowExecutionStateDefault("Etape_1");

		String wf = "nomDuWF \"desc\" {StepName: Etape_1 Comment: \"Le commentaire\" Calendar {StartingDate: 01/01/20 EndingDate: 31/01/20 } Synchro 02/02/20 false false 0 }"
				+ "{StepName: Etape_2 Comment: \"Le commentaire\" "
				+ "Survey {QuestionTitle: Q1 QuestionType: CheckBox PossibleAnswers: \"rep_1\" \"rep_2\" "
				+ "QuestionTitle: Q2 QuestionType: RadioButton PossibleAnswers: \"rep_3\" \"rep_4\"} "
				+ "Synchro 02/07/20 true true 10 } " + "{StepName: Etape_3 Comment: \"Le commentaire\" "
				+ "Survey {QuestionTitle: Q6 QuestionType: CheckBox PossibleAnswers: \"rep_5\" \"rep_6\"} Synchro 02/07/20 false false 0 }";
		ExecutionData ret = interpreterNathan.getStep(wf, state);

		ToStringSwitch toString = new ToStringSwitch();
		
		String str = toString.doSwitch(interpreterNathan.parse(wf));
		System.out.println(str);

		System.out.println("\nFirst call : ");

		System.out.println("Front object = " + ret.getStepDTO().getUserInteraction());
		System.out.println("Next step ID = " + ret.getNextStepID());

		System.out.println("\nSecond call : ");

		state = new WorkflowExecutionStateDefault("Etape_2");
		ret = interpreterNathan.getStep(wf, state);

		System.out.println("Front object = " + ret.getStepDTO().getUserInteraction());
		System.out.println("Next step ID = " + ret.getNextStepID());
	}

}
