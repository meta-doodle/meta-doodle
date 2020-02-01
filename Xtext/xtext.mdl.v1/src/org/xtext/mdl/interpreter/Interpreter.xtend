package org.xtext.mdl.interpreter

import org.xtext.mdl.v1.Etape

interface Interpreter {
	def int getIndexStep()
	def Etape getTypeStep()
	def boolean isChoiceStep()
}