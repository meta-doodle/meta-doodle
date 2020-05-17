package org.xtext.metadoodle.interpreter.implementation;

import org.xtext.metadoodle.mDL.AnswerTypeLan;

public enum UserInteractionType {
	CHECKBOX, RADIOBUTTON, TEXTFIELD, CALENDAR, FILE;

	public static UserInteractionType getUserInteractionType(AnswerTypeLan type) {
		switch (type.getType()) {
		case "OpenQuestion":
			return TEXTFIELD;
		case "CheckBox":
			return CHECKBOX;
		case "RadioButton":
			return RADIOBUTTON;
		default:
			//TODO make error
			return TEXTFIELD;
		}
	}
}
