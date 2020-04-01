package org.jhipster.mdl.fakeInterpreter;

import org.jhipster.mdl.workflow.to_transfert_data.QuestionData;
import org.jhipster.mdl.workflow.to_transfert_data.WorkflowStepData;

public class FakeInterpreter {
	
	public static final FakeInterpreter INTERPRETER = new FakeInterpreter();
	
	private WorkflowStepData[] steps = new WorkflowStepData[3];
	
	private FakeInterpreter() {
		steps[0] = new WorkflowStepData(new QuestionData("RADIOBOX", "Aimez vous les sondages ?", "Oui", "Non"),
				new QuestionData("TEXTFIELD", "Votre nombre préféré ?"));
		steps[1] = new WorkflowStepData(new QuestionData("DATE", "Jour de sortie", "06/04/2020", "15/04/2020"),
				new QuestionData("CHECKBOX", "Qu'aimeriez vous manger ?", "Pizza", "McDo"));
		steps[2] = new WorkflowStepData(new QuestionData("FILE", "Envoyer votre travail", "10"));
	}
	
	public FakeReturnExec exec(String model, FakeState state) {
		WorkflowStepData data = steps[state.step%3];
		return new FakeReturnExec(data, (state.step+1)%3);
	}
}
