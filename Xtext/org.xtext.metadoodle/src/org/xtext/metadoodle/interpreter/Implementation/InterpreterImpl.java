package org.xtext.metadoodle.interpreter.Implementation;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.xtext.metadoodle.MDLStandaloneSetup;
import org.xtext.metadoodle.interpreter.Interface.*;
import org.xtext.metadoodle.mDL.*;

import com.google.inject.Injector;

/**
 * Cette classe permet de traiter un workflow(wf) sous forme de String.
 * 
 * TODO : - Prise en compte des role (pas fait partout) - Vérifier l'unicité des
 * IDs.
 * 
 * @version 0.2
 */
public class InterpreterImpl implements Interpreter {
	/**
	 * Le logger.
	 */
	private final Logger LOG = Logger.getLogger(InterpreterImpl.class.getName());
	/**
	 * Liste des ast déjà calculé lié avec le model.
	 */
	private Map<String, EObject> astList;
//	private String errorMessage;
//	private boolean haveProblem;

	public InterpreterImpl() {
		astList = new HashMap<>();
//		errorMessage = "";
//		haveProblem = false;
	}

	@Override
	public StepDTOFactory getStep(String wfString, WorkflowExecutionState wes) {
		Objects.requireNonNull(wfString);
		Objects.requireNonNull(wes);

		LOG.info(">> " + wfString);
		return getStepDTOFactory((WorkflowLan) getRoot(wfString), wes);
	}

	/**
	 * Cette méthode passe le wfString dnas l'interpréteur et retourne la racine de
	 * l'ast.
	 * 
	 * @param wfString Le workflow.
	 * @return La racine de l'AST.
	 */
	private EObject getRoot(String wfString) {
		LOG.info(wfString.substring(0, 100) + "...");

		// Si l'ast est déjà présent, on le retourne.
		if (this.astList.containsKey(wfString))
			return this.astList.get(wfString);

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
		EObject ret = r.getParseResult().getRootASTElement();

		// Ajout de l'AST dans la liste.
		this.astList.put(wfString, ret);

		return ret;
	}

	/**
	 * Cette méthode permet de passer de workflowImpl (généré par xtext) à
	 * StepDTOFactory (géré par nous).
	 * 
	 * @param root
	 * @return Ne peut pas être null.
	 */
	private StepDTOFactory getStepDTOFactory(WorkflowLan root, WorkflowExecutionState wes) {

		Optional<WorkflowStepLan> optStep = findWorkflowStepLanByName(wes.getCurrentStepID(), root);
		if (!optStep.isPresent()) {
			String error = "No such Step in the WF";
			LOG.severe(error);
			return new NoStepDTOFact(wes.getCurrentStepID(), error);
		} else {
			LOG.info("Step '" + wes.getCurrentStepID() + "' found");
		}

		WorkflowStepLan curStepLan = optStep.get();

		Optional<WorkflowStepLan> rightStep = findRightCurrentStep(curStepLan, wes);
		if (!rightStep.isPresent()) {
			String error = "No more Step in the WF";
			LOG.info(error);
			return new NoStepDTOFact(wes.getCurrentStepID(), error);
		} else {
			LOG.info("Current Step is now "+rightStep.get().getName());
		}

		curStepLan = rightStep.get();

		return new StepDTOFactoryImpl(curStepLan);

//		Date curDate = new Date(), endStepDate;
//		String date;
//		boolean isFind = false;

//		// Récupération de l'ancienne étape courrante.
//		for(WorkflowStepLan stepLan : root.getSteps()) {
//			if(stepLan.getName().equals(wes.getCurrentStepID())) {
//				curStepLan = stepLan;
//			}
//		}

//		// récupération de la nouvelle étape courrante
//		while (!isFind) {
//
//			// ********** Vérification de la date **********
//			SynchroLan synchro = curStepLan.getSynchro();
//			date = synchro.getEndStepDate();
//
//			LOG.info("Parse : " + date);
//			try {
//				endStepDate = new SimpleDateFormat("dd/MM/yy").parse(date);
//
//				LOG.info("CurDate : " + curDate + " | stepDate : " + endStepDate);
//				if (endStepDate.before(curDate)) { // Si l'étape est passée,
//					curStepLan = getNextStepLan(curStepLan);
//					continue;
//				}
//			} catch (ParseException e) {
//				LOG.severe(e.getMessage());
//			}
//
//			// ********** Vérification du role **********
//			if (!curStepLan.getRole().getName().equals(wes.getRole())) {
//				return new NoStepDTOFact(curStepLan.getName(), "L'utilisateur n'a pas acces à cette étape.");
//				// TODO : peut-étre passer à l'étape suivante.
//			}
//
//			// ********** Vérification du taux de réponse **********
//			// Si l'étape a déjà été complété et que l'utilisateur ne veut pas
//			// la modifier.
//			if (wes.isStepComplete()) {
//				// Vérifier si possibilité de passer à l'étape suivante.
//				// TODO
//			}
//
//			isFind = true;
//		}

//		if (this.haveProblem) {
//			return new NoStepDTOFact(curStepLan.getName(), this.errorMessage);
//		}
//
//		return new StepDTOFactoryImpl(getStepDTO(curStepLan), getMailReminder(curStepLan, wes), curStepLan.getName());
	}

	private Optional<WorkflowStepLan> findWorkflowStepLanByName(String name, WorkflowLan workflowLan) {
		for (WorkflowStepLan workflowStepLan : workflowLan.getSteps()) {
			if (workflowStepLan.getName().equals(name)) {
				return Optional.of(workflowStepLan);
			}
		}
		return Optional.empty();
	}

	private Optional<WorkflowStepLan> findRightCurrentStep(WorkflowStepLan curStepLan, WorkflowExecutionState wes) {

		// check if all conditions are OK
		if(curStepLan.getRole() == null) {
			if (!isCurrentStepDone(curStepLan, wes)) {
				return Optional.of(curStepLan);
			}
		} else {
			if (wes.getRole().equals(curStepLan.getRole().getName()) && !isCurrentStepDone(curStepLan, wes)) {
				return Optional.of(curStepLan);
			}
		}
		
		LOG.info(curStepLan.getName() + " is skiped");

		Optional<WorkflowStepLan> nextWorkflowStepLan = getNextStepLan(curStepLan, wes);

		if (!nextWorkflowStepLan.isPresent()) {
			// We were on the last step
			return Optional.empty();
		}

		return findRightCurrentStep(nextWorkflowStepLan.get(), wes);

	}

	private boolean isCurrentStepDone(WorkflowStepLan curStepLan, WorkflowExecutionState wes) {
		SynchroLan stepSynchro = curStepLan.getSynchro();
		Date now = new Date();
		try {
			Date stepSynchroDate = new SimpleDateFormat("dd/MM/yy").parse(stepSynchro.getEndStepDate());

			LOG.info("CurDate : " + now + " | stepDate : " + stepSynchroDate);
			if (stepSynchroDate.before(now)) { // Si l'étape est passée,
				return true;
			}

		} catch (ParseException e) {
			LOG.severe(e.getMessage());
		}

		HasBeenAnsweredSwitch hasBeenAnsweredSwitch = new HasBeenAnsweredSwitch(wes, curStepLan.getName());

		// check if all UserInteraction has got an answer
		for (UserInteractionLan userInteractionLan : curStepLan.getUserInteraction()) {
			boolean answered = hasBeenAnsweredSwitch.doSwitch(userInteractionLan);
			if (!answered) {
				return false;
			}
		}

		return true;
	}

	private Optional<WorkflowStepLan> getNextStepLan(WorkflowStepLan curStepLan, WorkflowExecutionState wes) {
		WorkflowStepLan defaultNextStep = curStepLan.getNextStep();
		
		LOG.info("Checking Step : '"+curStepLan.getName()+"'");

		StepSwitch ss = new StepSwitch(wes, curStepLan.getName());

		Optional<WorkflowStepLan> ret = null;
		for (UserInteractionLan i : curStepLan.getUserInteraction()) {
			ret = ss.doSwitch(i);
			if (ret.isPresent()) {
				return ret;
			}
		}
		
		if (defaultNextStep == null) {
			// dernière étape.
			return Optional.empty();
		}

		return Optional.of(defaultNextStep);
	}

//	private StepDTOImpl getStepDTO(WorkflowStepLan stepLan) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	private MailReminder getMailReminder(WorkflowStepLan stepLan, WorkflowExecutionState wes) {
//		MailReminderLan mail = stepLan.getReminders();
//		MailReminderImpl ret = null;
//
//		if (mail != null) {
//			ret = new MailReminderImpl(mail.getObject(), mail.getBody());
//
//			for (String date : mail.getDateToSend())
//				ret.addDate(date);
//		}
//		return ret;
//	}

	// -----------------------------------------------------------

	@Override
	public WorkflowInstanceData getWorkflowData(String wfString) {
		WorkflowLan wfLan = (WorkflowLan) getRoot(wfString);
		List<String> roles = new ArrayList<>();

		for (RoleLan role : wfLan.getRoles()) {
			roles.add(role.getName());
		}

		return new WorkflowInstanceDataImpl(wfLan.getName(), wfLan.getDesc(), wfLan.getFirstStep().getName().toString(),
				roles);
	}

//	/**
//	 * Méthode de test.
//	 * 
//	 * @param args
//	 */
//	public static void main(String args[]) {
//		Interpreter i = new InterpreterImpl();
//		String wfInstance = "TODO"; // TODO
//
//		WorkflowExecutionState wes = new WorkflowExecutionState() {
//		};
//
//		StepDTOFactory ws = i.getStep(wfInstance, wes);
//		System.out.println(">>> " + ws);
//	}
}
