package org.jhipster.mdl.workflow.to_transfert_data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class WorkflowStepData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<QuestionData> questionViews;
	
	public WorkflowStepData(QuestionData...questionViews) {
		this.questionViews = Arrays.asList(questionViews);
	}
	
	public WorkflowStepData(List<QuestionData> questionView) {
		this.questionViews = questionView;
	}
	
	public List<QuestionData> getQuestionViews() {
		return questionViews;
	}
	
}
