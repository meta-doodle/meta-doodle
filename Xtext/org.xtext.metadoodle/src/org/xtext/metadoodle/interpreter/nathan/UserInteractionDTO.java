package org.xtext.metadoodle.interpreter.nathan;

import java.util.List;

public interface UserInteractionDTO {
	String getTitle();
	String getType();
	
	List<String> getOptions();
}
