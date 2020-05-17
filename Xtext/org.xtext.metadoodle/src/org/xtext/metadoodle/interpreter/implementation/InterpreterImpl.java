package org.xtext.metadoodle.interpreter.implementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
import org.xtext.metadoodle.interpreter.Interface.Interpreter;
import org.xtext.metadoodle.interpreter.Interface.StepDTOFactory;
import org.xtext.metadoodle.interpreter.Interface.WorkflowExecutionState;
import org.xtext.metadoodle.interpreter.Interface.WorkflowInstanceData;
import org.xtext.metadoodle.mDL.MailReminderLan;
import org.xtext.metadoodle.mDL.SynchroLan;
import org.xtext.metadoodle.mDL.UserInteractionLan;
import org.xtext.metadoodle.mDL.WorkflowLan;
import org.xtext.metadoodle.mDL.WorkflowStepLan;

import com.google.inject.Injector;

public class InterpreterImpl implements Interpreter {

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

	private Optional<WorkflowStepLan> getStepLan(String stepname, WorkflowLan wf) {

		for (WorkflowStepLan wfs : wf.getSteps()) {
			if (wfs.getName().equals(stepname)) {
				return Optional.of(wfs);
			}
		}
		return Optional.empty();
	}

	private boolean isStepFinished(WorkflowExecutionState wfs, WorkflowStepLan wfsteplan) {
		SynchroLan sync = wfsteplan.getSynchro();
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
		double percentageCompletion = wfs.getNumberAnwers(new IDImpl(wfsteplan.getName())) * 100
				/ wfs.getNumberOfUser();
		return wfs.isStepComplete() && percentageCompletion > sync.getPercentageCompletion();
	}

	@Override
	public StepDTOFactory getStep(String wf, WorkflowExecutionState wfs) {
		EObject o = parse(wf);

		if (!WorkflowLan.class.isInstance(o)) {
			// TODO make error
			System.out.println("cannot parse wf: [" + wf + "]");
			return null;
		}

		WorkflowLan workflowlan = (WorkflowLan) o;

		Optional<WorkflowStepLan> wfstep = getStepLan(wfs.getCurrentStepID().getID(), workflowlan);
		if (!wfstep.isPresent()) {
			// TODO error
		}
		WorkflowStepLan wfsteplan = wfstep.get();

		if (isStepFinished(wfs, wfsteplan)) {
			int index = workflowlan.getSteps().indexOf(wfsteplan);
			if (index < workflowlan.getSteps().size() - 1) {
				wfsteplan = workflowlan.getSteps().get(index + 1);
			}
		}
		
		StepDTOFactoryImpl dtoFactory = new StepDTOFactoryImpl(wfsteplan.getName());
		StepDTOImpl stepdto = dtoFactory.getStepDTOImpl();
		
		MailReminderLan mr = wfsteplan.getReminders();
		
		if (mr != null) {
			MailReminderImpl mrdto = new MailReminderImpl(mr.getObject(), mr.getBody(), mr.getDateToSend());
			dtoFactory.addMailReminder(mrdto);
		}
		

		// ajout des User Interactions dans stepdto
		UserInteractionSwitch interactionSwitch = new UserInteractionSwitch(stepdto);
		for (UserInteractionLan uil : wfsteplan.getUserInteraction()) {
			interactionSwitch.doSwitch(uil);
		}
		return dtoFactory;
	}

	@Override
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

	public static void main(String[] args) throws IOException {
		File file = new File("../Model/soiree_pizza.mdl");
//		System.out.println(file.exists());		
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String wfmodel = bufferedReader.lines().reduce((s1, s2) -> s1+"\n"+s2).orElse("");
		System.out.println(wfmodel);
		
		InterpreterImpl interpreter =  new InterpreterImpl();
		
		System.out.println(interpreter.getWorkflowData(wfmodel));
		
		WorkflowExecutionStateDefault defaultstate = new WorkflowExecutionStateDefault("lieu");
		
		System.out.println(interpreter.getStep(wfmodel, defaultstate));
		
		bufferedReader.close();

	}
}
