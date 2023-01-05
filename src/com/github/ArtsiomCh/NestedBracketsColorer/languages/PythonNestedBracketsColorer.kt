package com.github.ArtsiomCh.NestedBracketsColorer.languages

import com.github.ArtsiomCh.NestedBracketsColorer.*
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement

import com.jetbrains.python.PyTokenTypes.*

class PythonNestedBracketsColorer : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        annotateUtil(element, holder, LPAR, RPAR)
        annotateUtil(element, holder, LBRACKET, RBRACKET)
    }

}