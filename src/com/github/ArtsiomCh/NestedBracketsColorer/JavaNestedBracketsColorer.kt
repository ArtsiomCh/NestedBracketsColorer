package com.github.ArtsiomCh.NestedBracketsColorer

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.JavaTokenType.*
import com.intellij.psi.PsiElement

class JavaNestedBracketsColorer : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        annotateUtil(element, holder, LPARENTH, RPARENTH, roundBrackets)
        annotateUtil(element, holder, LBRACKET, RBRACKET, squareBrackets)
    }

}
