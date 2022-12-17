package com.github.ArtsiomCh.NestedBracketsColorer.languages

import com.github.ArtsiomCh.NestedBracketsColorer.*
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement

import com.jetbrains.rider.ideaInterop.fileTypes.csharp.kotoparser.lexer.CSharpTokenType.LPARENTH
import com.jetbrains.rider.ideaInterop.fileTypes.csharp.kotoparser.lexer.CSharpTokenType.RPARENTH
import com.jetbrains.rider.ideaInterop.fileTypes.csharp.kotoparser.lexer.CSharpTokenType.LT
import com.jetbrains.rider.ideaInterop.fileTypes.csharp.kotoparser.lexer.CSharpTokenType.GT
import com.jetbrains.rider.ideaInterop.fileTypes.csharp.kotoparser.lexer.CSharpTokenType.LBRACKET
import com.jetbrains.rider.ideaInterop.fileTypes.csharp.kotoparser.lexer.CSharpTokenType.RBRACKET

class CSharpNestedBracketsColorer : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        annotateUtil(element, holder, LPARENTH, RPARENTH, roundBrackets)
        annotateUtil(element, holder, LT, GT, roundBrackets)
        annotateUtil(element, holder, LBRACKET, RBRACKET, squareBrackets)
    }

}
