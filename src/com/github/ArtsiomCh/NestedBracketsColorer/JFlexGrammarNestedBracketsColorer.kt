package com.github.ArtsiomCh.NestedBracketsColorer

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement

import org.intellij.jflex.psi.JFlexTypes.*

class JFlexGrammarNestedBracketsColorer : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        annotateUtil(element, holder, FLEX_PAREN1, FLEX_PAREN2, roundBrackets)
    }

}

