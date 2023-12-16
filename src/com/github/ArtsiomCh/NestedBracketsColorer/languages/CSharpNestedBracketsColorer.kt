package com.github.ArtsiomCh.NestedBracketsColorer.languages

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement

class CSharpNestedBracketsColorer : Annotator {

    private fun hasClass(className: String): Boolean = try {
        Class.forName(className)
        true
    } catch (e: ClassNotFoundException) {
        false
    }

    private val hasCSharp233Support: Boolean =
        hasClass("com.jetbrains.rider.languages.fileTypes.csharp.kotoparser.lexer.CSharpTokenType")

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (hasCSharp233Support) CSharp233.annotate(element, holder) else CSharp232.annotate(element, holder)
    }

}
