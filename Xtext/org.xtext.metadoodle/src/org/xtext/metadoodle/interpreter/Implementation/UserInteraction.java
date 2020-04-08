package org.xtext.metadoodle.interpreter.Implementation;

import org.xtext.metadoodle.interpreter.Interface.ID;

public abstract class UserInteraction {
	public abstract ID getStepID();
	public abstract InteractionType getType();
}
