package org.xtext.metadoodle.interpreter.nathan;

import java.io.Serializable;
import java.util.List;

public interface StepDTO extends Serializable {
	List<UserInteractionDTO> getUserInteraction();
}
