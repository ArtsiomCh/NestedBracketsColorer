package com.github.ArtsiomCh.NestedBracketsColorer

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.PlainTextSyntaxHighlighterFactory
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.intellij.util.containers.ContainerUtil
import java.util.*
import javax.swing.Icon

internal val roundBracketLevel2 = TextAttributesKey.createTextAttributesKey(
        "round bracket level 2", DefaultLanguageHighlighterColors.STRING)
internal val roundBracketLevel3 = TextAttributesKey.createTextAttributesKey(
        "round bracket level 3", DefaultLanguageHighlighterColors.NUMBER)
internal val roundBracketLevel4 = TextAttributesKey.createTextAttributesKey(
        "round bracket level 4", DefaultLanguageHighlighterColors.DOC_COMMENT_TAG_VALUE)

class NBCColorSettingsPage : ColorSettingsPage {

    private val DESCRIPTORS = arrayOf(
        AttributesDescriptor("Bracket/brace level 2", roundBracketLevel2),
        AttributesDescriptor("Bracket/brace level 3", roundBracketLevel3),
        AttributesDescriptor("Bracket/brace level 4", roundBracketLevel4),
    )

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey> {
        return ContainerUtil.newHashMap(
                Arrays.asList("r2", "r3", "r4"),
                Arrays.asList(
                        roundBracketLevel2,
                        roundBracketLevel3,
                        roundBracketLevel4,
                )
        )
    }

    override fun getDisplayName(): String {
        return "Nested Brackets Colorer"
    }

    override fun getDemoText(): String {
        return """
Round () brackets:
level_1: ( level_2: <r2>(</r2> level_3: <r3>(</r3> level_4: <r4>(</r4><r4>)</r4><r3>)</r3><r2>)</r2>)

Square [] brackets (in some languages):
level_1: [ level_2: <r2>[</r2> level_3: <r3>[</r3> level_4: <r4>[</r4><r4>]</r4><r3>]</r3><r2>]</r2>]

Angled <> brackets (in some languages):
level_1: < level_2: <r2><</r2> level_3: <r3><</r3> level_4: <r4><</r4><r4>></r4><r3>></r3><r2>></r2>>

Braces {} in C# only:
level_1: { level_2: <r2>{</r2> level_3: <r3>{</r3> level_4: <r4>{</r4><r4>}</r4><r3>}</r3><r2>}</r2>}
"""
    }

    override fun getIcon(): Icon? {
        return null
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return PlainTextSyntaxHighlighterFactory().getSyntaxHighlighter( null, null)
    }

}