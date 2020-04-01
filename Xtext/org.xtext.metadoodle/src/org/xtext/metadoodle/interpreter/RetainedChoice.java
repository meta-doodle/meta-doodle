package org.xtext.metadoodle.interpreter;

public interface RetainedChoice {
	public ID getStepID();
	public ID getRequestID();
	public String getName();
	public String getAnswer(ID reqID);
}
