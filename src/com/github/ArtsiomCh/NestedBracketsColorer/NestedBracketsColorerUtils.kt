package com.github.ArtsiomCh.NestedBracketsColorer

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.openapi.editor.markup.TextAttributes
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.tree.IElementType
import java.awt.Color
import java.awt.Font

internal val roundBrackets = arrayOf(
        Color(255, 255, 255),
        Color(0, 169, 96),
        Color(33, 150, 243)
)

internal val squareBrackets = arrayOf(
        Color(255, 255, 255),
        Color(150, 80, 150)
//        Color(255, 152, 99)
)

internal fun annotateUtil(element: PsiElement, holder: AnnotationHolder,
                          LEFT: IElementType, RIGHT: IElementType, color: Array<Color>) {

    fun getBracketLevel(element: LeafPsiElement): Int {
        var level = if (element.elementType == RIGHT) 1 else 0

        tailrec fun iterateParents(currentNode: PsiElement) {

            tailrec fun iterateChilds(currentChild: PsiElement){
                if (currentChild is LeafPsiElement) {
                    when (currentChild.elementType) {
                        LEFT -> level++
                        RIGHT -> level--
                    }
                }
                if ((currentChild != currentNode) && (currentChild != currentNode.parent.lastChild)) {
                    iterateChilds(currentChild.nextSibling)
                }
            }

            if (currentNode.parent !is PsiFile) {
                iterateChilds(currentNode.parent.firstChild)
                iterateParents(currentNode.parent)
            }
        }

        iterateParents(element)
        return level
    }

    fun getColor (level: Int) = color[(level-1) % color.size]

    if (element is LeafPsiElement) {
        val level = when (element.elementType) {
            LEFT, RIGHT -> getBracketLevel(element)
            else -> 0
        }
        if (level > 1) {
            holder.createInfoAnnotation(element as PsiElement, null).enforcedTextAttributes =
                    TextAttributes( getColor(level), null, null, null, Font.PLAIN)
        }
    }
}



