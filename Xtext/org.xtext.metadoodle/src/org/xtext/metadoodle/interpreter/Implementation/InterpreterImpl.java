package org.xtext.metadoodle.interpreter.Implementation;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
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
 * @version 0.1
 */
public class InterpreterImpl implements Interpreter {
	/**
	 * A définir
	 */
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
	}

	@Override
	public WorkflowStep getStep(String wfString, WorkflowExecutionState wes) {
		Objects.requireNonNull(wfString);
		//Objects.requireNonNull(wes); // TODO à décommenter quand wesImpl sera implémenté.
		
		// TODO Utiliser wes.
		LOG.info(">> " + wfString);
		return getWorkflowStep((WorkflowLan) getRoot(wfString));
	}
	
	/**
	 * Cette méthode passe le wfString dnas l'interpréteur et retourne la racine de l'ast.
	 * @param wfString Le workflow.
	 * @return La racine de l'AST.
	 */
	private EObject getRoot(String wfString) {
		LOG.info(wfString.substring(0, 100) + "...");
		// Resource r = resSet.getResource(URI.createURI("wfInstance.mdl"), true);
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

	/**
	 * Cette méthode permet de passer de workflowImpl (généré par xtext) 
	 * à workflowStep (géré par nous).
	 * @param root
	 * @return Ne peut pas être null.
	 */
	private WorkflowStep getWorkflowStep(WorkflowLan root) {
		// Création du workflowStep.
		String nameWF = root.getName();
		String desc = root.getDesc();
		WorkflowStep wfStep = new WorkflowStepImpl(new IDImpl(nameWF), desc);
		
		// Récupération des UserInteractions.
		EList<WorkflowStepLan> steps = root.getSteps();
		UserInteraction ui = getUserInteraction(steps);
		
		if(ui != null)
			wfStep.addUserInteraction(ui);
		
		return wfStep;
	}
	
	/**
	 * 
	 * @param steps
	 * @return Peut-être null.
	 */
	private UserInteraction getUserInteraction(EList<WorkflowStepLan> steps) {
		UserInteraction ui = null;

		for(WorkflowStepLan step : steps) {
			
			// ********** Synchro **********
			
			SynchroLan synchro = step.getSynchro();
			Date curDate = new Date(), stepDate = null;
			
			try {
				stepDate = new SimpleDateFormat("dd/MM/yy").parse(synchro.getEndDate());
			} catch (ParseException e) {
				LOG.severe(e.getMessage());
			}
			
			LOG.info("CurDate : " + curDate + " | stepDate : " + stepDate);
			if(stepDate.before(curDate)) {
				continue; // Si l'étape est passée, on passe à la suivante.
			}
			
			// TODO gérer les autres options de Synchro.
			// ...
			
			// Ajout des questions.
			EList<UserInteractionLan> userInteractions = step.getUserInteraction();
			
			for(UserInteractionLan userInteraction : userInteractions) {
				String stepTypeName = userInteraction.getInteraction().getClass().getName().toUpperCase();
				
				if(stepTypeName.contains("SURVEY")) {
					ui = getForm(userInteraction.getInteraction(), step);
				}else if(stepTypeName.contains("CALENDAR")) {
					// TODO
				}else if(stepTypeName.contains("FILEUPLOAD")) {
					// TODO
				}else {
					LOG.severe("UserInteraction : " + step.getClass().getName() + " unknown.");
					break;
				}
			}
			
			// ********** Ajout du mailReminder. **********
			MailReminderLan mail = step.getReminders();
			
			if(mail != null) {
				MailReminder mr = new MailReminderImpl(mail.getObject(), mail.getBody());
				
				for(String date : mail.getDateToSend())
					mr.addDate(date);
				ui.setReminder(mr);
			}
			// Comme une seule step à besoin d'être retournée, 
			// on récupère la première dont la date n'est pas passé.
			break; 
		}
		return ui;
	}
	
	/**
	 * 
	 * @param sur
	 * @param step
	 * @return Ne peut pas être null.
	 */
	private Form getForm(SurveyLan sur, WorkflowStepLan step) {
		Form ret = new Form(new IDImpl(step.getName()), step.getComment(), InteractionType.FORM);
		EList<QuestionLan> qGen = sur.getQuestions();
		
		for(QuestionLan question : qGen) {
			String type = null, name = question.getType().getType();
			
			if(name.toUpperCase().contains("OPENQUESTION"))
				type = "FREEANSWER";
			else if(name.toUpperCase().contains("CHECKBOX"))
				type = "CHECKBOX";
			else if(name.toUpperCase().contains("RADIOBUTTON"))
				type = "RADIOBUTTON";
			else 
				LOG.severe("Answer Type unknown." + name);
			
			LOG.info(type);
			QuestionForm qCreate = new QuestionForm(question.getName(), AnswerType.valueOf(type));
			EList<String> reps = question.getResponses();
			
			for(String rep : reps)
				qCreate.addAnswer(rep);
			
			ret.addQuestion(qCreate);
		}
		
		return ret;
	}
	
	/**
	 * Main de test.
	 * @param args
	 */
	public static void main(String args[]) {
		Interpreter i = new InterpreterImpl();
		String wfInstance = "nomDuWF \"desc\" {StepName:Etape_1 Comment:\"Le commentaire\" Survey {QuestionTitle: Q1 QuestionType: CheckBox PossibleAnswers: \"rep_1\" \"rep_2\"} Synchro 02/07/20 false false 0 }";
		WorkflowStep ws = i.getStep(wfInstance, null);
		System.out.println(">>> " + ws);
	}
}