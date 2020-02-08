package org.xtext.mdl.interpreter

import org.xtext.mdl.v1.util.V1Switch
import org.xtext.mdl.v1.QCM
import org.xtext.mdl.v1.SynchDate
import org.xtext.mdl.v1.Depot
import org.xtext.mdl.v1.Mail
import org.xtext.mdl.v1.V1Factory

class TestSwitch extends V1Switch<Boolean> {
	
	override caseQCM(QCM object) {
		return Boolean.TRUE
	}
	
	override caseSynchDate(SynchDate object) {
		return Boolean.TRUE
	}
	
	override caseDepot(Depot object) {
		return Boolean.FALSE
	}
	
	override caseMail(Mail object) {
		return Boolean.FALSE
	}
	
	def static void main(String[] args) {
		val s = new TestSwitch
		val f = V1Factory.eINSTANCE
		val depot = f.createDepot
		val qcm= f.createQCM
		println(s.doSwitch(depot))
		println(s.doSwitch(qcm))
	}
	
}