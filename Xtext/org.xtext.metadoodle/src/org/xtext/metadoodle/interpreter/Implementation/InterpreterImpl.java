package org.xtext.metadoodle.interpreter.Implementation;

import java.io.InputStream;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
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

	// TODO fragmenter cette methode.
	@Override
	public WorkflowStep getStep(String wfString, WorkflowExecutionState wes) {
		LOG.info(">> " + wfString);

		final WorkflowLan toplevel = (WorkflowLan) getRoot(wfString);
		
		// TODO Passer de workflowImpl (généré par xtext) à workflowStep (géré par nous).
		// Création du workflowStep.
		String nameWF = toplevel.getName();
		String desc = toplevel.getDesc();
		
		WorkflowStep wfStep = new WorkflowStepImpl(new IDImpl(nameWF), desc);
		
		// Ajout des UserInteractions.
		EList<WorkflowStepLan> steps = toplevel.getSteps();
		
		for(WorkflowStepLan step : steps) {
			// Ajout des questions.
			UserInteraction ui = null;
			EList<UserInteractionLan> userInteractions = step.getUserInteraction();
			
			for(UserInteractionLan userInteraction : userInteractions) {
				String stepTypeName = userInteraction.getInteraction().getClass().getName().toUpperCase();
				
				if(stepTypeName.contains("SURVEY")) {
					SurveyLan sur = userInteraction.getInteraction();
					ui = new Form(new IDImpl(step.getName()), step.getComment(), InteractionType.FORM);
					
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
						
						((Form)ui).addQuestion(qCreate);
					}
				}else if(stepTypeName.contains("CALENDAR")) {
					
				}else if(stepTypeName.contains("FILEUPLOAD")) {
					
				}else {
					LOG.severe("UserInteraction : " + step.getClass().getName() + " unknown.");
					break;
				}
			}
			
			// Ajout mailReminder.
			MailReminderLan mail = step.getReminders();
			MailReminder mr = new MailReminderImpl(mail.getObject(), mail.getBody());
			
			for(String date : mail.getDateToSend())
				mr.addDate(date);
			
			ui.setReminder(mr);
			
			// synchro
			SynchroLan sync = step.getSynchro();
			
			// TODO
			
			wfStep.addUserInteraction(ui);
		}
		
		return wfStep;
	}
	
	/**
	 * Cette méthode passe le wfString dnas l'interpréteur et retourne la racine de l'ast.
	 * @param wfString Le workflow.
	 * @return La racine de l'AST.
	 */
	private EObject getRoot(String wfString) {

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
		EcoreUtil.resolveAll(r);
		return r.getParseResult().getRootASTElement();
	}

	/**
	 * Main de test.
	 * @param args
	 */
	public static void main(String args[]) {
		Interpreter i = new InterpreterImpl();

		String wfInstance = "nomDuWF \"desc\" {StepName:Etape_1 Comment:\"Le commentaire\" Survey {QuestionTitle: Q1 QuestionType: CheckBox PossibleAnswers: \"rep_1\" \"rep_2\"} Synchro 01/01/20 false false 0 }";

		WorkflowStep ws = i.getStep(wfInstance, null);

		System.out.println(">>> " + ws);
	}
}
