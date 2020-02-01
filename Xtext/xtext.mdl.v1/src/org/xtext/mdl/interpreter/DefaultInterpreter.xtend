package org.xtext.mdl.interpreter

import com.google.inject.Injector
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.xtext.mdl.V1StandaloneSetup
import org.xtext.mdl.v1.Etape
import org.xtext.mdl.v1.Workflow

class DefaultInterpreter implements Interpreter {
	
	EObject root
	Etape currentEtape
	Workflow workflow
	int indexStep = 0
	
	new(String pathName) {
		val Injector injector = new V1StandaloneSetup().createInjectorAndDoEMFRegistration();
		val ResourceSet resourceSet = injector.getInstance(ResourceSet);
		val Resource r = resourceSet.getResource(URI.createURI(pathName), true);
		r.load(null);

		root = r.allContents.head.eContainer
		if(Workflow.isInstance(root)){
			workflow = Workflow.cast(root)
		} else {
			println("error on parsing")
			// TODO generate error
		}
		currentEtape = workflow.etapes.head
		if(currentEtape === null){
			print("error : le wf n'a pas d'etape")
			// TODO : faire une meilleure erreur
		}
	}
	
	override getIndexStep() {
		return indexStep
	}
	
	override getTypeStep() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override isChoiceStep() {
		val s= new TestSwitch
		val resultSwitch = s.doSwitch(currentEtape)
		return resultSwitch.booleanValue
	}
	
	private def nextStep() {
		indexStep++
		if(workflow.etapes.length >= indexStep){
			// TODO : end of WF
		} else {
			currentEtape = workflow.etapes.get(indexStep)
		}
	}
	
	def static void main(String[] args) {
		val s = new TestSwitch
		println(s.doSwitch(new Depottest))
		println(s.doSwitch(new QCMTest))
	}
	
}
