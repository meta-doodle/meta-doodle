/*
 * generated by Xtext 2.19.0
 */
package org.xtext.dsl.v1


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class V1StandaloneSetup extends V1StandaloneSetupGenerated {

	def static void doSetup() {
		new V1StandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}
