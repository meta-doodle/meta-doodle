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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.mdl.v1.Etape;
import org.xtext.mdl.v1.V1Package;
import org.xtext.mdl.v1.Workflow;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workflow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.mdl.v1.impl.WorkflowImpl#getDateDebut <em>Date Debut</em>}</li>
 *   <li>{@link org.xtext.mdl.v1.impl.WorkflowImpl#getEtapes <em>Etapes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WorkflowImpl extends MinimalEObjectImpl.Container implements Workflow
{
  /**
   * The default value of the '{@link #getDateDebut() <em>Date Debut</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDateDebut()
   * @generated
   * @ordered
   */
  protected static final String DATE_DEBUT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDateDebut() <em>Date Debut</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDateDebut()
   * @generated
   * @ordered
   */
  protected String dateDebut = DATE_DEBUT_EDEFAULT;

  /**
   * The cached value of the '{@link #getEtapes() <em>Etapes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEtapes()
   * @generated
   * @ordered
   */
  protected EList<Etape> etapes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WorkflowImpl()
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
    return V1Package.Literals.WORKFLOW;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getDateDebut()
  {
    return dateDebut;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDateDebut(String newDateDebut)
  {
    String oldDateDebut = dateDebut;
    dateDebut = newDateDebut;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, V1Package.WORKFLOW__DATE_DEBUT, oldDateDebut, dateDebut));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Etape> getEtapes()
  {
    if (etapes == null)
    {
      etapes = new EObjectContainmentEList<Etape>(Etape.class, this, V1Package.WORKFLOW__ETAPES);
    }
    return etapes;
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
      case V1Package.WORKFLOW__ETAPES:
        return ((InternalEList<?>)getEtapes()).basicRemove(otherEnd, msgs);
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
      case V1Package.WORKFLOW__DATE_DEBUT:
        return getDateDebut();
      case V1Package.WORKFLOW__ETAPES:
        return getEtapes();
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
      case V1Package.WORKFLOW__DATE_DEBUT:
        setDateDebut((String)newValue);
        return;
      case V1Package.WORKFLOW__ETAPES:
        getEtapes().clear();
        getEtapes().addAll((Collection<? extends Etape>)newValue);
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
      case V1Package.WORKFLOW__DATE_DEBUT:
        setDateDebut(DATE_DEBUT_EDEFAULT);
        return;
      case V1Package.WORKFLOW__ETAPES:
        getEtapes().clear();
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
      case V1Package.WORKFLOW__DATE_DEBUT:
        return DATE_DEBUT_EDEFAULT == null ? dateDebut != null : !DATE_DEBUT_EDEFAULT.equals(dateDebut);
      case V1Package.WORKFLOW__ETAPES:
        return etapes != null && !etapes.isEmpty();
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
    result.append(" (dateDebut: ");
    result.append(dateDebut);
    result.append(')');
    return result.toString();
  }

} //WorkflowImpl
