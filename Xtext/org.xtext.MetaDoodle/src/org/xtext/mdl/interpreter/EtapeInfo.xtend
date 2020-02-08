package org.xtext.mdl.interpreter

import java.util.List
import java.io.Serializable

class EtapeInfo implements Serializable {
	public val ReponseType reponseType;
	public val String commentaire
	public val List<String> restrictions
	
	new(ReponseType reponseType, String commentaire, List<String> restrictions) {
		this.reponseType = reponseType
		this.commentaire = commentaire
		this.restrictions = restrictions
	}
	
}