package org.xtext.metadoodle.interpreter.nathan;

import java.util.List;

import org.xtext.metadoodle.mDL.QuestionLan;

class UserInteractionImpl implements UserInteractionDTO {
	
	private String title;
	private List<String> options;
	private String type;
	
	public UserInteractionImpl(QuestionLan questionLan) {
		title = questionLan.getName();
		type = questionLan.getType().getType();
		options = questionLan.getResponses();
	}

	public UserInteractionImpl(String title, List<String> options, String type) {
		this.title = title;
		this.options = options;
		this.type = type;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public List<String> getOptions() {
		return options;
	}

	@Override
	public String getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return "UserInteraction{title=\"" + title + "\", type=" + type + ", options="+options+"}";
	}
	
}
