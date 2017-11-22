package com.github.ArtsiomCh.NestedBracketsColorer

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement

import org.jetbrains.kotlin.lexer.KtTokens.*

class KotlinNestedBracketsColorer : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        annotateUtil( element, holder, LPAR, RPAR, roundBrackets )
        annotateUtil( element, holder, LBRACKET, RBRACKET, squareBrackets )
    }

}
