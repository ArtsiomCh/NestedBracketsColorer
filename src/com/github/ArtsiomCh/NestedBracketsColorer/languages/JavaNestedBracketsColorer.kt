package com.github.ArtsiomCh.NestedBracketsColorer.languages

import com.github.ArtsiomCh.NestedBracketsColorer.annotateUtil
import com.github.ArtsiomCh.NestedBracketsColorer.roundBrackets
import com.github.ArtsiomCh.NestedBracketsColorer.squareBrackets
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.JavaTokenType.*
import com.intellij.psi.PsiElement

class JavaNestedBracketsColorer : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        annotateUtil(element, holder, LPARENTH, RPARENTH, roundBrackets)
        annotateUtil(element, holder, LBRACKET, RBRACKET, squareBrackets)
        annotateUtil(element, holder, LT, GT, roundBrackets)
    }

}
