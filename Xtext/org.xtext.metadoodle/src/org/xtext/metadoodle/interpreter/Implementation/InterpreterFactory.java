package org.xtext.metadoodle.interpreter.Implementation;

import org.xtext.metadoodle.interpreter.Interface.Interpreter;

public class InterpreterFactory {
	
	public static Interpreter createInterpreter() {
		return new InterpreterImpl();
	}
}
