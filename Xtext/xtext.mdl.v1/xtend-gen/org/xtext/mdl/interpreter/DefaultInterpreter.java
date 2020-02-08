package org.xtext.mdl.interpreter;

import com.google.inject.Injector;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.xtext.mdl.V1StandaloneSetup;
import org.xtext.mdl.interpreter.Depottest;
import org.xtext.mdl.interpreter.Interpreter;
import org.xtext.mdl.interpreter.QCMTest;
import org.xtext.mdl.interpreter.TestSwitch;
import org.xtext.mdl.v1.Etape;
import org.xtext.mdl.v1.Workflow;

@SuppressWarnings("all")
public class DefaultInterpreter implements Interpreter {
  private EObject root;
  
  private Etape currentEtape;
  
  private Workflow workflow;
  
  private int indexStep = 0;
  
  public DefaultInterpreter(final String pathName) {
    try {
      final Injector injector = new V1StandaloneSetup().createInjectorAndDoEMFRegistration();
      final ResourceSet resourceSet = injector.<ResourceSet>getInstance(ResourceSet.class);
      final Resource r = resourceSet.getResource(URI.createURI(pathName), true);
      r.load(null);
      this.root = IteratorExtensions.<EObject>head(r.getAllContents()).eContainer();
      boolean _isInstance = Workflow.class.isInstance(this.root);
      if (_isInstance) {
        this.workflow = Workflow.class.cast(this.root);
      } else {
        InputOutput.<String>println("error on parsing");
      }
      this.currentEtape = IterableExtensions.<Etape>head(this.workflow.getEtapes());
      if ((this.currentEtape == null)) {
        InputOutput.<String>print("error : le wf n\'a pas d\'etape");
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public int getIndexStep() {
    return this.indexStep;
  }
  
  @Override
  public Etape getTypeStep() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public boolean isChoiceStep() {
    final TestSwitch s = new TestSwitch();
    final Boolean resultSwitch = s.doSwitch(this.currentEtape);
    return resultSwitch.booleanValue();
  }
  
  private Etape nextStep() {
    Etape _xblockexpression = null;
    {
      this.indexStep++;
      Etape _xifexpression = null;
      int _length = ((Object[])Conversions.unwrapArray(this.workflow.getEtapes(), Object.class)).length;
      boolean _greaterEqualsThan = (_length >= this.indexStep);
      if (_greaterEqualsThan) {
        _xifexpression = null;
      } else {
        _xifexpression = this.currentEtape = this.workflow.getEtapes().get(this.indexStep);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public static void main(final String[] args) {
    final TestSwitch s = new TestSwitch();
    Depottest _depottest = new Depottest();
    InputOutput.<Boolean>println(s.doSwitch(_depottest));
    QCMTest _qCMTest = new QCMTest();
    InputOutput.<Boolean>println(s.doSwitch(_qCMTest));
  }
}
