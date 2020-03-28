package org.jhipster.mdl.workflow.to_transfert_data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class QuestionData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String reponseType;
	
	private String intitule;
	
	private List<String> restrictions;
	
	public QuestionData(String reponseType, String intitule, String...restrictions) {
		this.reponseType = reponseType;
		this.intitule = intitule;
		this.restrictions = Arrays.asList(restrictions);
	}
	
	public QuestionData(String reponseType, String intitule, List<String> restrictions) {
		this.reponseType = reponseType;
		this.intitule = intitule;
		this.restrictions = restrictions;
	}
	
	public String getIntitule() {
		return intitule;
	}
	
	public String getReponseType() {
		return reponseType;
	}
	
	public List<String> getRestrictions() {
		return restrictions;
	}

}
