package com.github.ArtsiomCh.NestedBracketsColorer.languages

import com.github.ArtsiomCh.NestedBracketsColorer.*
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement

import org.jetbrains.plugins.scala.lang.lexer.ScalaTokenTypes.*

class ScalaNestedBracketsColorer : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        annotateUtil(element, holder, tLPARENTHESIS, tRPARENTHESIS)
        annotateUtil(element, holder, tLSQBRACKET, tRSQBRACKET)
    }

}
