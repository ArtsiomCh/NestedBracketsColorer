package com.github.ArtsiomCh.NestedBracketsColorer

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement

import com.jetbrains.php.lang.lexer.PhpTokenTypes.*

class PHPNestedBracketsColorer : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        annotateUtil( element, holder, chLPAREN, chRPAREN, roundBrackets )
        annotateUtil( element, holder, chLBRACKET, chRBRACKET, squareBrackets )
    }

}
