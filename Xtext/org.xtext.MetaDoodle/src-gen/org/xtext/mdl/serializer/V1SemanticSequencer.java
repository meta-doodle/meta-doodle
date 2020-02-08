/*
 * generated by Xtext 2.20.0
 */
package org.xtext.mdl.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.xtext.mdl.services.V1GrammarAccess;
import org.xtext.mdl.v1.CondFin;
import org.xtext.mdl.v1.Contenu;
import org.xtext.mdl.v1.Depot;
import org.xtext.mdl.v1.Mail;
import org.xtext.mdl.v1.QCM;
import org.xtext.mdl.v1.Rappel;
import org.xtext.mdl.v1.Step;
import org.xtext.mdl.v1.SynchDate;
import org.xtext.mdl.v1.TypeQCM;
import org.xtext.mdl.v1.V1Package;
import org.xtext.mdl.v1.Workflow;

@SuppressWarnings("all")
public class V1SemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private V1GrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == V1Package.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case V1Package.COND_FIN:
				sequence_CondFin(context, (CondFin) semanticObject); 
				return; 
			case V1Package.CONTENU:
				sequence_Contenu(context, (Contenu) semanticObject); 
				return; 
			case V1Package.DEPOT:
				sequence_Depot(context, (Depot) semanticObject); 
				return; 
			case V1Package.MAIL:
				sequence_Mail(context, (Mail) semanticObject); 
				return; 
			case V1Package.OBJECT:
				sequence_Object(context, (org.xtext.mdl.v1.Object) semanticObject); 
				return; 
			case V1Package.QCM:
				sequence_QCM(context, (QCM) semanticObject); 
				return; 
			case V1Package.RAPPEL:
				sequence_Rappel(context, (Rappel) semanticObject); 
				return; 
			case V1Package.STEP:
				sequence_Step(context, (Step) semanticObject); 
				return; 
			case V1Package.SYNCH_DATE:
				sequence_SynchDate(context, (SynchDate) semanticObject); 
				return; 
			case V1Package.TYPE_QCM:
				sequence_TypeQCM(context, (TypeQCM) semanticObject); 
				return; 
			case V1Package.WORKFLOW:
				sequence_Workflow(context, (Workflow) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     CondFin returns CondFin
	 *
	 * Constraint:
	 *     (date=DATE ParticipantsRequired=INT?)
	 */
	protected void sequence_CondFin(ISerializationContext context, CondFin semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Contenu returns Contenu
	 *
	 * Constraint:
	 *     corps=STRING
	 */
	protected void sequence_Contenu(ISerializationContext context, Contenu semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, V1Package.Literals.CONTENU__CORPS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, V1Package.Literals.CONTENU__CORPS));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getContenuAccess().getCorpsSTRINGTerminalRuleCall_0(), semanticObject.getCorps());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Depot returns Depot
	 *
	 * Constraint:
	 *     (intitule=STRING limiteSize=INT format+=STRING*)
	 */
	protected void sequence_Depot(ISerializationContext context, Depot semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Mail returns Mail
	 *
	 * Constraint:
	 *     (expediteur=ADDRESSEMAIL destinataire+=ADDRESSEMAIL+ pj=STRING? corps=Contenu)
	 */
	protected void sequence_Mail(ISerializationContext context, Mail semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Object returns Object
	 *
	 * Constraint:
	 *     ((obj=QCM cond=CondFin) | (mail=Mail dateEnvoi=DATE) | (synchDate=SynchDate cond=CondFin) | depot=Depot | dateFin=DATE)
	 */
	protected void sequence_Object(ISerializationContext context, org.xtext.mdl.v1.Object semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     QCM returns QCM
	 *
	 * Constraint:
	 *     (type=TypeQCM intitule=STRING responses+=STRING* suite=QCM?)
	 */
	protected void sequence_QCM(ISerializationContext context, QCM semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Rappel returns Rappel
	 *
	 * Constraint:
	 *     (date+=DATE+ mail=Mail)
	 */
	protected void sequence_Rappel(ISerializationContext context, Rappel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Step returns Step
	 *
	 * Constraint:
	 *     (id=INT name=STRING rappels+=Rappel* obj=Object)
	 */
	protected void sequence_Step(ISerializationContext context, Step semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SynchDate returns SynchDate
	 *
	 * Constraint:
	 *     (start=DATE end=DATE precision=STRING?)
	 */
	protected void sequence_SynchDate(ISerializationContext context, SynchDate semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TypeQCM returns TypeQCM
	 *
	 * Constraint:
	 *     (OPENQUESTION='OpenQuestion' | CHECKBOX='CheckBox' | RADIOBUTTON='RadioButton')
	 */
	protected void sequence_TypeQCM(ISerializationContext context, TypeQCM semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Workflow returns Workflow
	 *
	 * Constraint:
	 *     ((dateDebut=DATE steps+=Step+) | steps+=Step+)?
	 */
	protected void sequence_Workflow(ISerializationContext context, Workflow semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}