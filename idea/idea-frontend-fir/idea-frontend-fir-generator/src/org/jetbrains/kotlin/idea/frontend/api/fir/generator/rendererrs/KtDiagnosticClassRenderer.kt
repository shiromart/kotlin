/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.frontend.api.fir.generator.rendererrs

import org.jetbrains.kotlin.fir.checkers.generator.inBracketsWithIndent
import org.jetbrains.kotlin.fir.tree.generator.printer.SmartPrinter
import org.jetbrains.kotlin.idea.frontend.api.fir.generator.HLDiagnostic
import org.jetbrains.kotlin.idea.frontend.api.fir.generator.HLDiagnosticList
import org.jetbrains.kotlin.idea.frontend.api.fir.generator.collectClassNamesTo
import org.jetbrains.kotlin.idea.frontend.api.fir.generator.printTypeWithShortNames
import com.intellij.psi.PsiElement

object KtDiagnosticClassRenderer : AbstractDiagnosticsDataClassRenderer() {
    override fun SmartPrinter.render(diagnosticList: HLDiagnosticList, packageName: String) {
        printHeader(packageName, diagnosticList)
        printDiagnosticClasses(diagnosticList)
    }


    @OptIn(ExperimentalStdlibApi::class)
    override fun collectImports(diagnosticList: HLDiagnosticList): Collection<String> = buildSet {
        addAll(importsToAdd)
        for (diagnostic in diagnosticList.diagnostics) {
            diagnostic.original.psiType.collectClassNamesTo(this)
            diagnostic.parameters.forEach { diagnosticParameter ->
                diagnosticParameter.type.collectClassNamesTo(this)
            }
        }
    }

    private fun SmartPrinter.printDiagnosticClasses(diagnosticList: HLDiagnosticList) {
        inBracketsWithIndent("sealed class KtFirDiagnostic<PSI: PsiElement> : KtDiagnosticWithPsi<PSI>") {
            for (diagnostic in diagnosticList.diagnostics) {
                printDiagnosticClass(diagnostic)
                println()
            }
        }
    }

    private fun SmartPrinter.printDiagnosticClass(diagnostic: HLDiagnostic) {
        print("abstract class ${diagnostic.className} : KtFirDiagnostic<")
        printTypeWithShortNames(diagnostic.original.psiType)
        print(">()")
        inBracketsWithIndent {
            println("override val diagnosticClass get() = ${diagnostic.className}::class")
            printDiagnosticParameters(diagnostic)
        }
    }

    private fun SmartPrinter.printDiagnosticParameters(diagnostic: HLDiagnostic) {
        diagnostic.parameters.forEach { parameter ->
            print("abstract val ${parameter.name}: ")
            printTypeWithShortNames(parameter.type)
            println()
        }
    }


    private val importsToAdd = listOf(
        "org.jetbrains.kotlin.idea.frontend.api.diagnostics.KtDiagnosticWithPsi",
        "com.intellij.psi.PsiElement",
    )
}