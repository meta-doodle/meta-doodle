package org.xtext.metadoodle.interpreter.Implementation;

import java.util.Objects;
import java.util.Optional;

import org.xtext.metadoodle.interpreter.Interface.MailReminder;
import org.xtext.metadoodle.interpreter.Interface.StepDTO;
import org.xtext.metadoodle.interpreter.Interface.StepDTOFactory;

public class StepDTOFactoryImpl implements StepDTOFactory{

	private StepDTOImpl step;
	private MailReminder mail;
	private String currentStepID;
	
	public StepDTOFactoryImpl(StepDTOImpl step, MailReminder mail, String id){
		Objects.requireNonNull(step);
		Objects.requireNonNull(id);
		
		this.step = step;
		this.mail = mail;
		this.currentStepID = id;
	}
	
	@Override
	public Optional<MailReminder> getMailReminder() {
		if(this.mail == null) {
			return Optional.empty();
		}
		return Optional.of(this.mail);
	}

	@Override
	public String getCurrentStepID() {
		return this.currentStepID.toString();
	}

	@Override
	public StepDTO Build() {
		return this.step;
	}

	@Override
	public void addResponses(String questionID, String response) {
		Objects.requireNonNull(questionID);
		Objects.requireNonNull(response);
		
		this.step.getUserInteractionDTO(questionID).addResponse(response);
	}

	@Override
	public Optional<String> getMessage() {
		return Optional.empty();
	}
}
