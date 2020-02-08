package org.xtext.mdl.interpreter;

import org.xtext.mdl.v1.Etape;

@SuppressWarnings("all")
public interface Interpreter {
  public abstract int getIndexStep();
  
  public abstract Etape getTypeStep();
  
  public abstract boolean isChoiceStep();
}
