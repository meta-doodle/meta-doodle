/**
 * generated by Xtext 2.19.0
 */
package org.xtext.mdl.v1.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.xtext.mdl.v1.TypeQCM;
import org.xtext.mdl.v1.V1Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type QCM</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.mdl.v1.impl.TypeQCMImpl#getOPENQUESTION <em>OPENQUESTION</em>}</li>
 *   <li>{@link org.xtext.mdl.v1.impl.TypeQCMImpl#getCHECKBOX <em>CHECKBOX</em>}</li>
 *   <li>{@link org.xtext.mdl.v1.impl.TypeQCMImpl#getRADIOBUTTON <em>RADIOBUTTON</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeQCMImpl extends MinimalEObjectImpl.Container implements TypeQCM
{
  /**
   * The default value of the '{@link #getOPENQUESTION() <em>OPENQUESTION</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOPENQUESTION()
   * @generated
   * @ordered
   */
  protected static final String OPENQUESTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOPENQUESTION() <em>OPENQUESTION</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOPENQUESTION()
   * @generated
   * @ordered
   */
  protected String openquestion = OPENQUESTION_EDEFAULT;

  /**
   * The default value of the '{@link #getCHECKBOX() <em>CHECKBOX</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCHECKBOX()
   * @generated
   * @ordered
   */
  protected static final String CHECKBOX_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCHECKBOX() <em>CHECKBOX</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCHECKBOX()
   * @generated
   * @ordered
   */
  protected String checkbox = CHECKBOX_EDEFAULT;

  /**
   * The default value of the '{@link #getRADIOBUTTON() <em>RADIOBUTTON</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRADIOBUTTON()
   * @generated
   * @ordered
   */
  protected static final String RADIOBUTTON_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRADIOBUTTON() <em>RADIOBUTTON</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRADIOBUTTON()
   * @generated
   * @ordered
   */
  protected String radiobutton = RADIOBUTTON_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeQCMImpl()
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
    return V1Package.Literals.TYPE_QCM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getOPENQUESTION()
  {
    return openquestion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOPENQUESTION(String newOPENQUESTION)
  {
    String oldOPENQUESTION = openquestion;
    openquestion = newOPENQUESTION;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, V1Package.TYPE_QCM__OPENQUESTION, oldOPENQUESTION, openquestion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getCHECKBOX()
  {
    return checkbox;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setCHECKBOX(String newCHECKBOX)
  {
    String oldCHECKBOX = checkbox;
    checkbox = newCHECKBOX;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, V1Package.TYPE_QCM__CHECKBOX, oldCHECKBOX, checkbox));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getRADIOBUTTON()
  {
    return radiobutton;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRADIOBUTTON(String newRADIOBUTTON)
  {
    String oldRADIOBUTTON = radiobutton;
    radiobutton = newRADIOBUTTON;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, V1Package.TYPE_QCM__RADIOBUTTON, oldRADIOBUTTON, radiobutton));
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
      case V1Package.TYPE_QCM__OPENQUESTION:
        return getOPENQUESTION();
      case V1Package.TYPE_QCM__CHECKBOX:
        return getCHECKBOX();
      case V1Package.TYPE_QCM__RADIOBUTTON:
        return getRADIOBUTTON();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case V1Package.TYPE_QCM__OPENQUESTION:
        setOPENQUESTION((String)newValue);
        return;
      case V1Package.TYPE_QCM__CHECKBOX:
        setCHECKBOX((String)newValue);
        return;
      case V1Package.TYPE_QCM__RADIOBUTTON:
        setRADIOBUTTON((String)newValue);
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
      case V1Package.TYPE_QCM__OPENQUESTION:
        setOPENQUESTION(OPENQUESTION_EDEFAULT);
        return;
      case V1Package.TYPE_QCM__CHECKBOX:
        setCHECKBOX(CHECKBOX_EDEFAULT);
        return;
      case V1Package.TYPE_QCM__RADIOBUTTON:
        setRADIOBUTTON(RADIOBUTTON_EDEFAULT);
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
      case V1Package.TYPE_QCM__OPENQUESTION:
        return OPENQUESTION_EDEFAULT == null ? openquestion != null : !OPENQUESTION_EDEFAULT.equals(openquestion);
      case V1Package.TYPE_QCM__CHECKBOX:
        return CHECKBOX_EDEFAULT == null ? checkbox != null : !CHECKBOX_EDEFAULT.equals(checkbox);
      case V1Package.TYPE_QCM__RADIOBUTTON:
        return RADIOBUTTON_EDEFAULT == null ? radiobutton != null : !RADIOBUTTON_EDEFAULT.equals(radiobutton);
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
    result.append(" (OPENQUESTION: ");
    result.append(openquestion);
    result.append(", CHECKBOX: ");
    result.append(checkbox);
    result.append(", RADIOBUTTON: ");
    result.append(radiobutton);
    result.append(')');
    return result.toString();
  }

} //TypeQCMImpl
