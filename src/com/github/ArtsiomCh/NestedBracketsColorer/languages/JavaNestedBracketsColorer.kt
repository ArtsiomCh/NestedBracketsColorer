package com.github.ArtsiomCh.NestedBracketsColorer.languages

import com.github.ArtsiomCh.NestedBracketsColorer.annotateUtil
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.JavaTokenType.*
import com.intellij.psi.PsiElement

class JavaNestedBracketsColorer : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        annotateUtil(element, holder, LPARENTH, RPARENTH)
        annotateUtil(element, holder, LBRACKET, RBRACKET)
        annotateUtil(element, holder, LT, GT)
    }

}
