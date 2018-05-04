package com.github.ArtsiomCh.NestedBracketsColorer.languages

import com.github.ArtsiomCh.NestedBracketsColorer.annotateUtil
import com.github.ArtsiomCh.NestedBracketsColorer.roundBrackets
import com.github.ArtsiomCh.NestedBracketsColorer.squareBrackets
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement

import com.intellij.lang.javascript.JSTokenTypes.*

class JSNestedBracketsColorer : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        annotateUtil(element, holder, LPAR, RPAR, roundBrackets)
        annotateUtil(element, holder, LBRACKET, RBRACKET, squareBrackets)
    }

}
