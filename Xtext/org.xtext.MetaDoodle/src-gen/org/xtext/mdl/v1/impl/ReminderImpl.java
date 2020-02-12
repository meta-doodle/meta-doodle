/**
 * generated by Xtext 2.19.0
 */
package org.xtext.mdl.v1.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.xtext.mdl.v1.Mail;
import org.xtext.mdl.v1.Reminder;
import org.xtext.mdl.v1.V1Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reminder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.mdl.v1.impl.ReminderImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.xtext.mdl.v1.impl.ReminderImpl#getMail <em>Mail</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReminderImpl extends MinimalEObjectImpl.Container implements Reminder
{
  /**
   * The cached value of the '{@link #getDate() <em>Date</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDate()
   * @generated
   * @ordered
   */
  protected EList<String> date;

  /**
   * The cached value of the '{@link #getMail() <em>Mail</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMail()
   * @generated
   * @ordered
   */
  protected Mail mail;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReminderImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return V1Package.Literals.REMINDER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<String> getDate()
  {
    if (date == null)
    {
      date = new EDataTypeEList<String>(String.class, this, V1Package.REMINDER__DATE);
    }
    return date;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Mail getMail()
  {
    return mail;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMail(Mail newMail, NotificationChain msgs)
  {
    Mail oldMail = mail;
    mail = newMail;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, V1Package.REMINDER__MAIL, oldMail, newMail);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setMail(Mail newMail)
  {
    if (newMail != mail)
    {
      NotificationChain msgs = null;
      if (mail != null)
        msgs = ((InternalEObject)mail).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - V1Package.REMINDER__MAIL, null, msgs);
      if (newMail != null)
        msgs = ((InternalEObject)newMail).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - V1Package.REMINDER__MAIL, null, msgs);
      msgs = basicSetMail(newMail, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, V1Package.REMINDER__MAIL, newMail, newMail));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case V1Package.REMINDER__MAIL:
        return basicSetMail(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case V1Package.REMINDER__DATE:
        return getDate();
      case V1Package.REMINDER__MAIL:
        return getMail();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case V1Package.REMINDER__DATE:
        getDate().clear();
        getDate().addAll((Collection<? extends String>)newValue);
        return;
      case V1Package.REMINDER__MAIL:
        setMail((Mail)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case V1Package.REMINDER__DATE:
        getDate().clear();
        return;
      case V1Package.REMINDER__MAIL:
        setMail((Mail)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case V1Package.REMINDER__DATE:
        return date != null && !date.isEmpty();
      case V1Package.REMINDER__MAIL:
        return mail != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (date: ");
    result.append(date);
    result.append(')');
    return result.toString();
  }

} //ReminderImpl