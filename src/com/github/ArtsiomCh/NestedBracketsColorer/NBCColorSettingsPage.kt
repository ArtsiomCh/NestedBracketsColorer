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

internal val squareBracketLevel2 = TextAttributesKey.createTextAttributesKey(
        "square bracket level 2", DefaultLanguageHighlighterColors.INSTANCE_FIELD)
internal val squareBracketLevel3 = TextAttributesKey.createTextAttributesKey(
        "square bracket level 3", DefaultLanguageHighlighterColors.INSTANCE_METHOD)

class NBCColorSettingsPage : ColorSettingsPage {

    private val DESCRIPTORS = arrayOf(
        AttributesDescriptor("Round bracket level 2", roundBracketLevel2),
        AttributesDescriptor("Round bracket level 3", roundBracketLevel3),
        AttributesDescriptor("Round bracket level 4", roundBracketLevel4),
            AttributesDescriptor("Square bracket level 2", squareBracketLevel2),
            AttributesDescriptor("Square bracket level 3", squareBracketLevel3)
    )

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey> {
        return ContainerUtil.newHashMap(
                Arrays.asList("r2", "r3", "r4", "s2", "s3"),
                Arrays.asList(
                        roundBracketLevel2,
                        roundBracketLevel3,
                        roundBracketLevel4,
                        squareBracketLevel2,
                        squareBracketLevel3
                )
        )
    }

    override fun getDisplayName(): String {
        return "Nested Brackets Colorer"
    }

    override fun getDemoText(): String {
        return  "Round () brackets:\n" +
                "level_1: ( level_2: <r2>(</r2> level_3: <r3>(</r3> level_4: <r4>(</r4>" +
                "<r4>)</r4><r3>)</r3><r2>)</r2>)\n\n" +
                "Angled () brackets:\n" +
                "level_1: < level_2: <r2><</r2> level_3: <r3><</r3> level_4: <r4><</r4>" +
                "<r4>></r4><r3>></r3><r2>></r2>)\n\n" +
                "Square [] brackets:\n" +
                "level_1: [ level_2: <s2>[</s2> level_3: <s3>[</s3> <s3>]</s3><s2>]</s2>]\n"
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