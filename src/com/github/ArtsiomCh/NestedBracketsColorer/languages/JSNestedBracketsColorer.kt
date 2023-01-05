package com.github.ArtsiomCh.NestedBracketsColorer.languages

import com.github.ArtsiomCh.NestedBracketsColorer.annotateUtil
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement

import com.intellij.lang.javascript.JSTokenTypes.*

class JSNestedBracketsColorer : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        annotateUtil(element, holder, LPAR, RPAR)
        annotateUtil(element, holder, LBRACKET, RBRACKET)
    }

}
