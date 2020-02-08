/**
 * generated by Xtext 2.20.0
 */
package org.xtext.mdl.v1;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.mdl.v1.Object#getObj <em>Obj</em>}</li>
 *   <li>{@link org.xtext.mdl.v1.Object#getCond <em>Cond</em>}</li>
 *   <li>{@link org.xtext.mdl.v1.Object#getMail <em>Mail</em>}</li>
 *   <li>{@link org.xtext.mdl.v1.Object#getDateEnvoi <em>Date Envoi</em>}</li>
 *   <li>{@link org.xtext.mdl.v1.Object#getSynchDate <em>Synch Date</em>}</li>
 *   <li>{@link org.xtext.mdl.v1.Object#getDepot <em>Depot</em>}</li>
 *   <li>{@link org.xtext.mdl.v1.Object#getDateFin <em>Date Fin</em>}</li>
 * </ul>
 *
 * @see org.xtext.mdl.v1.V1Package#getObject()
 * @model
 * @generated
 */
public interface Object extends EObject
{
  /**
   * Returns the value of the '<em><b>Obj</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Obj</em>' containment reference.
   * @see #setObj(QCM)
   * @see org.xtext.mdl.v1.V1Package#getObject_Obj()
   * @model containment="true"
   * @generated
   */
  QCM getObj();

  /**
   * Sets the value of the '{@link org.xtext.mdl.v1.Object#getObj <em>Obj</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Obj</em>' containment reference.
   * @see #getObj()
   * @generated
   */
  void setObj(QCM value);

  /**
   * Returns the value of the '<em><b>Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cond</em>' containment reference.
   * @see #setCond(CondFin)
   * @see org.xtext.mdl.v1.V1Package#getObject_Cond()
   * @model containment="true"
   * @generated
   */
  CondFin getCond();

  /**
   * Sets the value of the '{@link org.xtext.mdl.v1.Object#getCond <em>Cond</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cond</em>' containment reference.
   * @see #getCond()
   * @generated
   */
  void setCond(CondFin value);

  /**
   * Returns the value of the '<em><b>Mail</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mail</em>' containment reference.
   * @see #setMail(Mail)
   * @see org.xtext.mdl.v1.V1Package#getObject_Mail()
   * @model containment="true"
   * @generated
   */
  Mail getMail();

  /**
   * Sets the value of the '{@link org.xtext.mdl.v1.Object#getMail <em>Mail</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mail</em>' containment reference.
   * @see #getMail()
   * @generated
   */
  void setMail(Mail value);

  /**
   * Returns the value of the '<em><b>Date Envoi</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Date Envoi</em>' attribute.
   * @see #setDateEnvoi(String)
   * @see org.xtext.mdl.v1.V1Package#getObject_DateEnvoi()
   * @model
   * @generated
   */
  String getDateEnvoi();

  /**
   * Sets the value of the '{@link org.xtext.mdl.v1.Object#getDateEnvoi <em>Date Envoi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Date Envoi</em>' attribute.
   * @see #getDateEnvoi()
   * @generated
   */
  void setDateEnvoi(String value);

  /**
   * Returns the value of the '<em><b>Synch Date</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Synch Date</em>' containment reference.
   * @see #setSynchDate(SynchDate)
   * @see org.xtext.mdl.v1.V1Package#getObject_SynchDate()
   * @model containment="true"
   * @generated
   */
  SynchDate getSynchDate();

  /**
   * Sets the value of the '{@link org.xtext.mdl.v1.Object#getSynchDate <em>Synch Date</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Synch Date</em>' containment reference.
   * @see #getSynchDate()
   * @generated
   */
  void setSynchDate(SynchDate value);

  /**
   * Returns the value of the '<em><b>Depot</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Depot</em>' containment reference.
   * @see #setDepot(Depot)
   * @see org.xtext.mdl.v1.V1Package#getObject_Depot()
   * @model containment="true"
   * @generated
   */
  Depot getDepot();

  /**
   * Sets the value of the '{@link org.xtext.mdl.v1.Object#getDepot <em>Depot</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Depot</em>' containment reference.
   * @see #getDepot()
   * @generated
   */
  void setDepot(Depot value);

  /**
   * Returns the value of the '<em><b>Date Fin</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Date Fin</em>' attribute.
   * @see #setDateFin(String)
   * @see org.xtext.mdl.v1.V1Package#getObject_DateFin()
   * @model
   * @generated
   */
  String getDateFin();

  /**
   * Sets the value of the '{@link org.xtext.mdl.v1.Object#getDateFin <em>Date Fin</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Date Fin</em>' attribute.
   * @see #getDateFin()
   * @generated
   */
  void setDateFin(String value);

} // Object