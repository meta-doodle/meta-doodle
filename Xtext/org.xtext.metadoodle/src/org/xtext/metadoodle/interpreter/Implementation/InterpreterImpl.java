package org.xtext.metadoodle.interpreter.Implementation;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
 * @version 0.1
 */
public class InterpreterImpl implements Interpreter {
	/**
	 * Le logger.
	 */
	private final Logger LOG = Logger.getLogger(InterpreterImpl.class.getName());

	@Override
	public WorkflowStep getStep(String wfString, WorkflowExecutionState wes) {
		Objects.requireNonNull(wfString);
		//Objects.requireNonNull(wes);
		
		// TODO Utiliser wes.
		LOG.info(">> " + wfString);
		return getWorkflowStep((WorkflowLan) getRoot(wfString), wes);
	}
	
	/**
	 * Cette méthode passe le wfString dnas l'interpréteur et retourne la racine de l'ast.
	 * @param wfString Le workflow.
	 * @return La racine de l'AST.
	 */
	private EObject getRoot(String wfString) {
		LOG.info(wfString.substring(0, 100) + "...");

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

	/**
	 * Cette méthode permet de passer de workflowImpl (généré par xtext) 
	 * à workflowStep (géré par nous).
	 * @param root
	 * @return Ne peut pas être null.
	 */
	private WorkflowStep getWorkflowStep(WorkflowLan root, WorkflowExecutionState wes) {
		// Création du workflowStep.
		String nameWF = root.getName();
		String desc = root.getDesc();
		WorkflowStepImpl wfStep = new WorkflowStepImpl(new IDImpl(nameWF), desc);
		
		// Récupération des UserInteractions.
		EList<WorkflowStepLan> steps = root.getSteps();
		Optional<UserInteraction> ui = getUserInteraction(steps, wes);
		
		if(ui.isPresent())
			wfStep.addUserInteraction(ui.get());
		
		wfStep.setIDNextStep(getNextID(steps, wes.getCurrentStepID()));
		
		return wfStep;
	}
	
	/**
	 * Cette méthode permet de récupérer l'ID de l'étape suivante.
	 * @param steps La liste des étapes.
	 * @param id L'id de l'étape courrante.
	 * @return L'id de l'étape suivante.
	 */
	private ID getNextID(EList<WorkflowStepLan> steps, ID id) {
		ID ret = null;
		Boolean find = false;
		
		for(WorkflowStepLan wsl : steps) {
			if(find) {
				ret = new IDImpl(wsl.getName());
				break;
			}
			if(wsl.getName().equals(id.toString())) {
				find = true;
			}
		}
		
		return ret;
	}
	
	/**
	 * Retourne la nouvelle étape courrante ou null si l'étape est finit et que l'étape suivante 
	 * est blockée. 
	 * @param steps
	 * @return Peut-être null.
	 */
	private Optional<UserInteraction> getUserInteraction(EList<WorkflowStepLan> steps, WorkflowExecutionState wes) {
		UserInteraction ret = null, previousUI = null;
		boolean findCurrentID = false, needNextUI = true;
		SynchroLan synchro;
		Date curDate, stepDate;
		int percentageCompletion;
		

		for(WorkflowStepLan step : steps) {
			LOG.info("Etape : " + step.getName());
			synchro = step.getSynchro();
			curDate = new Date(); 
			stepDate = null;
			
			if(!wes.getCurrentStepID().toString().equals(step.getName()) && !findCurrentID) { // étape précédente
				continue;
			} else if(wes.getCurrentStepID().toString().equals(step.getName())){ // étape courrante
				findCurrentID = true;
				percentageCompletion = wes.getNumberAnwers(new IDImpl(step.getName())) * 100 / wes.getNumberOfUser();
				
				LOG.info(step.getUserInteraction().size() + "");
				
				if(synchro.getWaitOtherUsers().equals("true") 
						&& synchro.getPercentageCompletionUse().equals("true")) {
					if(wes.isStepComplete() && percentageCompletion < synchro.getPercentageCompletion()) {
						needNextUI = false;
					}
				}
			}
			
			// ********** Vérification de la date **********
			try {
				LOG.info(synchro.getEndStepDate());
				stepDate = new SimpleDateFormat("dd/MM/yy").parse(synchro.getEndStepDate());
			} catch (ParseException e) {
				LOG.severe(e.getMessage());
			}
			
			LOG.info("CurDate : " + curDate + " | stepDate : " + stepDate);
			if(stepDate.before(curDate)) { // Si l'étape est passée,
				needNextUI = true;
				continue; // on passe à la suivante.
			}
			
			// Ajout des questions.
			EList<UserInteractionLan> userInteractions = step.getUserInteraction();
			
			for(UserInteractionLan userInteraction : userInteractions) {
				String stepTypeName = userInteraction.getInteraction().getClass().getName().toUpperCase();
				
				if(stepTypeName.contains("SURVEY")) {
					ret = getForm(userInteraction.getInteraction(), step);
				}else if(stepTypeName.contains("CALENDAR")) {
					ret = getCalendar((CalendarLan) userInteraction.getInteraction(), step);
				}else if(stepTypeName.contains("FILEUPLOAD")) {
					ret = getFileUpload((FileUploadLan) userInteraction.getInteraction(), step);
				}else {
					LOG.severe("UserInteraction : " + step.getClass().getName() + " unknown.");
					break; // TODO Es-ce qu'on le laisse ???
				}
			}
			
			// ********** Ajout du mailReminder. **********
			MailReminderLan mail = step.getReminders();
			
			if(mail != null) {
				MailReminderImpl mr = new MailReminderImpl(mail.getObject(), mail.getBody());
				
				for(String date : mail.getDateToSend())
					mr.addDate(date);
				LOG.info("UserInteraction add.");
				ret.setReminder(mr);
			}
			// Comme une seule step à besoin d'être retournée, 
			// on récupère la première dont la date n'est pas passé.
			if(needNextUI) {
				needNextUI = false;
				previousUI = ret;
			}else {
				break;
			}
		}
		// Retourne l'étape précédente si la dernière étape n'est pas valide.
		if(ret == null)
			ret = previousUI;
		if(ret == null)
			return Optional.empty();
		return Optional.of(ret);
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
	 * Si la précision n'est pas renseigné, la valeur par défault est un jour.
	 * @param cal
	 * @param step
	 * @return
	 */
	private Calendar getCalendar(CalendarLan cal, WorkflowStepLan step) {
		String accuracy = cal.getAccuracy();
		
		if(accuracy == null)
			accuracy = "1:day";
		
		return new Calendar(
				new IDImpl(step.getName()), 
				step.getComment(), 
				InteractionType.CALENDAR, 
				cal.getStart(), 
				cal.getEnd(), 
				accuracy);
	}
	
	/**
	 * 
	 * @param fileUp
	 * @param step
	 * @return
	 */
	private FileUpload getFileUpload(FileUploadLan fileUp, WorkflowStepLan step) {
		List<String> mimeTypes = new ArrayList<>();
		
		for(String mimeType : fileUp.getMimeTypes())
			mimeTypes.add(mimeType);
		
		return new FileUpload(
				new IDImpl(step.getName()), 
				step.getComment(), 
				InteractionType.FILEUPLOAD, 
				mimeTypes);
	}
	
	@Override
	public WorkflowInstanceData getWorkflowData(String wfString) {
		WorkflowLan wfLan = (WorkflowLan) getRoot(wfString);
		String IDFirstStep = null;
		
		for(WorkflowStepLan step : wfLan.getSteps()) {
			IDFirstStep = step.getName();
			break;
		}
		
		return new WorkflowInstanceDataImpl(wfLan.getName(), wfLan.getDesc(), IDFirstStep);
	}
	
	/**
	 * Méthode de test.
	 * @param args
	 */
	public static void main(String args[]) {
		Interpreter i = new InterpreterImpl();
		String wfInstance = "nomDuWF \"desc\" {StepName:Etape_1 Comment:\"Le commentaire\" Survey {QuestionTitle: Q1 QuestionType: CheckBox PossibleAnswers: \"rep_1\" \"rep_2\"} Synchro 02/07/20 false false 0 }";
		//String wfInstance = "nomDuWF \"desc\" {StepName: Etape_1 Comment: \"Le commentaire\" CalendarLan {StartingDate: 01/01/20 EndingDate: 31/01/20 } Synchro 02/07/20 false false 0 }";
		
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
			public Optional<Answer> getPreviousAnswer(ID reqID, ID stepID) {
				return null;
			}
			@Override
			public int getNumberOfUser() {
				return 3;
			}
			@Override
			public int getNumberAnwers(ID stepID) {
				return 0;
			}
			@Override
			public ID getCurrentStepID() {
				return new IDImpl("Etape_1");
			}
			@Override
			public Optional<Answer> getCurrentAnswer() {
				return null;
			}
		};
		
		WorkflowStep ws = i.getStep(wfInstance, wes);
		System.out.println(">>> " + ws);
	}
}
