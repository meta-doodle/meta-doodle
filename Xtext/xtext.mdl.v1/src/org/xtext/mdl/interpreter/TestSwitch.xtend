package org.xtext.mdl.interpreter

import org.xtext.mdl.v1.util.V1Switch
import org.xtext.mdl.v1.QCM
import org.xtext.mdl.v1.SynchDate
import org.xtext.mdl.v1.Depot
import org.xtext.mdl.v1.Mail

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
	
}