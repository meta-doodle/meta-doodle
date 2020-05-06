package org.xtext.metadoodle.interpreter.Implementation;

	import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
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
 * TODO : - Prise en compte des role (pas fait partout)
 * - Vérifier l'unicité des IDs.
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
	
	public InterpreterImpl() {
		astList = new HashMap<>();
	}
	
	@Override
	public StepDTOFactory getStep(String wfString, WorkflowExecutionState wes) {
		Objects.requireNonNull(wfString);
		Objects.requireNonNull(wes);
		
		LOG.info(">> " + wfString);
		return getStepDTOFactory((WorkflowLan) getRoot(wfString), wes);
	}
	
	/**
	 * Cette méthode passe le wfString dnas l'interpréteur et retourne la racine de l'ast.
	 * @param wfString Le workflow.
	 * @return La racine de l'AST.
	 */
	private EObject getRoot(String wfString) {
		LOG.info(wfString.substring(0, 100) + "...");
		
		// Si l'ast est déjà présent, on le retourne.
		if(this.astList.containsKey(wfString))
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
	 * Cette méthode permet de passer de workflowImpl (généré par xtext) 
	 * à StepDTOFactory (géré par nous).
	 * @param root
	 * @return Ne peut pas être null.
	 */
	private StepDTOFactory getStepDTOFactory(WorkflowLan root, WorkflowExecutionState wes) {

		String[] data = getStepLanID(root, wes);
		
		// TODO à améliorer (pas propre).
		if(data[1] != null) { // s'il y a un message d'erreur, ...
			return new NoStepDTOFact(data[0], data[1]);
		}
		
		// Récupération de la bonne étape.
		WorkflowStepLan stepLan = getStepLan(root, data[0]);
		
		
		return new StepDTOFactoryImpl(getStepDTO(stepLan), getMailReminder(stepLan, wes), data[0]);
	}
	
	private String[] getStepLanID(WorkflowLan root, WorkflowExecutionState wes) {
		Date curDate = new Date(), endStepDate;
		String date, stepID[] = new String[2];
		boolean isFind = false;
		WorkflowStepLan curStepLan = getStepLan(root, wes.getCurrentStepID().toString());
		
		while(!isFind) {
			// ********** Vérification de la date **********
			SynchroLan synchro = curStepLan.getSynchro();
			date = wes.getDateChoosen().get(synchro.getEndStepDate().getId());
			
			LOG.info("Parse : " + date);
			try {
				endStepDate = new SimpleDateFormat("dd/MM/yy").parse(date);

				LOG.info("CurDate : " + curDate + " | stepDate : " + endStepDate);
				if(endStepDate.before(curDate)) { // Si l'étape est passée,
					stepID[0] = curStepLan.getNextStep().getName();
					curStepLan = getStepLan(root, stepID[0]);
					continue;
				}
			} catch (ParseException e) {
				LOG.severe(e.getMessage());
			}

			// ********** Vérification du taux de réponse **********
			// Si l'étape a déjà été complété et que l'utilisateur ne veut pas 
			// la modifier.
			if(wes.isStepComplete() && !wes.wantModifyThisStep()) { 
				// Vérifier si possibilité de passer à l'étape suivante.
				// TODO
			}
			
			// ********** Vérification du role **********
			// TODO
		}
		
		
		return stepID;
	}

	private WorkflowStepLan getStepLan(WorkflowLan root, String id) {
		Objects.requireNonNull(root);
		Objects.requireNonNull(id);
		
		for(WorkflowStepLan stepLan : root.getSteps()) {
			if(stepLan.getName().getName().equals(id)) {
				return stepLan;
			}
		}
		
		throw new IllegalArgumentException("L'étape : " + id + " est inconnu dans le workflow : " + root.getName());
	}

	private StepDTOImpl getStepDTO(WorkflowStepLan stepLan) {
		// TODO Auto-generated method stub
		return null;
	}

	private MailReminder getMailReminder(WorkflowStepLan stepLan, WorkflowExecutionState wes) {
		MailReminderLan mail = stepLan.getReminders();
		MailReminderImpl ret = null;
		
		if(mail != null) {
			ret = new MailReminderImpl(mail.getObject(), mail.getBody());
			
			for(DateIDLan date : mail.getDateToSend())
				ret.addDate(wes.getDateChoosen().get(date.getId()));
		}
		return ret;
	}
	
	// -----------------------------------------------------------
	
	@Override
	public WorkflowInstanceData getWorkflowData(String wfString) {
		WorkflowLan wfLan = (WorkflowLan) getRoot(wfString);
		List<String> roles = new ArrayList<>();
		
		for(RoleLan role : wfLan.getRoles()) {
			roles.add(role.getName());
		}
		
		return new WorkflowInstanceDataImpl(
				wfLan.getName(), 
				wfLan.getDesc(), 
				wfLan.getFirstStep().getName().toString(), 
				roles);
	}
	
	/**
	 * Méthode de test.
	 * @param args
	 */
	public static void main(String args[]) {
		Interpreter i = new InterpreterImpl();
		String wfInstance = "TODO"; // TODO
		
		WorkflowExecutionState wes = new WorkflowExecutionState() {
			@Override
			public boolean isStepComplete() {
				return false;
			}
			@Override
			public RetainedChoice getPreviousRetainedChoice(String name) {
				return null;
			}
			@Override
			public Optional<Answer> getPreviousAnswer(String reqID, String stepID) {
				return null;
			}
			@Override
			public int getNumberOfUser() {
				return 3;
			}
			@Override
			public int getNumberAnwers(String stepID) {
				return 0;
			}
			@Override
			public String getCurrentStepID() {
				return "Etape_1";
			}
			@Override
			public Optional<Answer> getCurrentAnswer() {
				return null;
			}
			@Override
			public Map<String, String> getDateChoosen() {
				return null;
			}
			@Override
			public boolean wantModifyThisStep() {
				return false;
			}
		};
		
		StepDTOFactory ws = i.getStep(wfInstance, wes);
		System.out.println(">>> " + ws);
	}
}
