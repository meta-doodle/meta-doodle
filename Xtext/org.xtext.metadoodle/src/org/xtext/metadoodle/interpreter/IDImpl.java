package org.xtext.metadoodle.interpreter;

public class IDImpl implements ID {

	private String id;
	
	public IDImpl(String id) {
		this.id = id;
	}
	
	public String toString() {
		return this.id;
	}
}
