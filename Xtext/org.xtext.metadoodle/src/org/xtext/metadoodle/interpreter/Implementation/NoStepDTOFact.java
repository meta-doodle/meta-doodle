package org.xtext.metadoodle.interpreter.Implementation;

import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;
import org.xtext.metadoodle.interpreter.Interface.MailReminder;
import org.xtext.metadoodle.interpreter.Interface.StepDTO;
import org.xtext.metadoodle.interpreter.Interface.StepDTOFactory;

public class NoStepDTOFact implements StepDTOFactory {

	private final Logger LOG = Logger.getLogger(NoStepDTOFact.class.getName());
	
	private String curStepID, desc; 
	
	public NoStepDTOFact(String id, String desc) {
		Objects.requireNonNull(id);
		Objects.requireNonNull(desc);
		
		this.curStepID = id;
		this.desc = desc;
	}
	
	@Override
	public Optional<MailReminder> getMailReminder() {
		return Optional.empty();
	}

	@Override
	public String getCurrentStepID() {
		return this.curStepID;
	}

	@Override
	public StepDTO Build() {
		return null;
	}

	@Override
	public void addResponses(String questionID, String response){
		LOG.severe("Error : This is not a step.");
	}

	@Override
	public Optional<String> getError() {
		return Optional.of(this.desc);
	}
}
