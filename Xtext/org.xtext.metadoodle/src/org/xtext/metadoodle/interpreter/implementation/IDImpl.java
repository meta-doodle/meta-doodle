package org.xtext.metadoodle.interpreter.implementation;

import org.xtext.metadoodle.interpreter.Interface.ID;

public class IDImpl implements ID {

	private String id;
	
	public IDImpl(String id) {
		this.id = id;
	}

	@Override
	public String getID() {
		return this.id;
	}
}