package org.xtext.mdl.interpreter

import org.xtext.mdl.interpreter.Interpreter
import java.util.List
import java.util.ArrayList

class FakeInterpreter implements Interpreter {
	
	override getEtapeInfo(int nbEtape) {
		val List<String> restrictions = new ArrayList;
		// Fake interpretation
		switch (nbEtape) {
			case 0: {
				restrictions.add("choix1");
				restrictions.add("choix2");
				return new EtapeInfo(ReponseType.CHECKBOX, "Une question de choix : ", restrictions);
			}
			case 1: {
				return new EtapeInfo(ReponseType.TEXTFIELD, "Un commetaire a faire ? :", restrictions)
			}
			case 2: {
				restrictions.add("06/02/2020")
				restrictions.add("10/06/2020")
				return new EtapeInfo(ReponseType.DATE, "Choisir une date : ", restrictions)
			}
			case 3: {
				restrictions.add("choix1")
				restrictions.add("choix2")
				return new EtapeInfo(ReponseType.RADIOBOX, "Choisir en radiobutton : ", restrictions)
			}
			case 4: {
				restrictions.add("100.0")
				return new EtapeInfo(ReponseType.FILE, "Votre rapport : ", restrictions)
			}
			default: {
				throw new IllegalArgumentException("There is no "+ nbEtape + "th etape")
			}
		}
	}
	
	override nbEtapes() {
		// Fake interpretation
		return 5
	}
	
}