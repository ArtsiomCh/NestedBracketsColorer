package com.github.ArtsiomCh.NestedBracketsColorer

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.tree.IElementType

internal val roundBrackets = arrayOf(
    roundBracketLevel4,
    roundBracketLevel2,
    roundBracketLevel3
)

internal val squareBrackets = arrayOf(
    squareBracketLevel3,
    squareBracketLevel2
)

internal fun annotateUtil(
    element: PsiElement, holder: AnnotationHolder,
    LEFT: IElementType, RIGHT: IElementType,
    brackets: Array<TextAttributesKey>
) {

    fun getBracketLevel(element: LeafPsiElement): Int {
        var level = if (element.elementType == RIGHT) 1 else 0

        tailrec fun iterateParents(currentNode: PsiElement) {

            tailrec fun iterateChilds(currentChild: PsiElement) {
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

    fun getBracketTextAttributesKey(level: Int) = brackets[(level - 1) % brackets.size]

    if (element is LeafPsiElement) {
        val level = when (element.elementType) {
            LEFT, RIGHT -> getBracketLevel(element)
            else -> 0
        }
        if (level > 1) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(element as PsiElement)
                .textAttributes(getBracketTextAttributesKey(level))
                .create()
        }
    }
}



