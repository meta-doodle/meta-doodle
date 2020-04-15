package org.xtext.metadoodle.interpreter.Implementation;

import org.xtext.metadoodle.interpreter.Interface.ID;

public class IDImpl implements ID {

	private String id;
	
	public IDImpl(String id) {
		this.id = id;
	}
	
	public String toString() {
		return this.id;
	}

	@Override
	public String getID() {
		return this.id;
	}
}
