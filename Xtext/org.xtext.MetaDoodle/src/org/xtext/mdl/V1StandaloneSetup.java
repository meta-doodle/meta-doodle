/*
 * generated by Xtext 2.20.0
 */
package org.xtext.mdl;


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class V1StandaloneSetup extends V1StandaloneSetupGenerated {

	public static void doSetup() {
		new V1StandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
