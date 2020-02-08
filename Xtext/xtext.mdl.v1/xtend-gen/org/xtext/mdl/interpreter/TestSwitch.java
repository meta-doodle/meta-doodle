package org.xtext.mdl.interpreter;

import org.xtext.mdl.v1.Depot;
import org.xtext.mdl.v1.Mail;
import org.xtext.mdl.v1.QCM;
import org.xtext.mdl.v1.SynchDate;
import org.xtext.mdl.v1.util.V1Switch;

@SuppressWarnings("all")
public class TestSwitch extends V1Switch<Boolean> {
  @Override
  public Boolean caseQCM(final QCM object) {
    return Boolean.TRUE;
  }
  
  @Override
  public Boolean caseSynchDate(final SynchDate object) {
    return Boolean.TRUE;
  }
  
  @Override
  public Boolean caseDepot(final Depot object) {
    return Boolean.FALSE;
  }
  
  @Override
  public Boolean caseMail(final Mail object) {
    return Boolean.FALSE;
  }
}
