
package com.Forsys.ui.actions;

/**
 * Commonly used html attributes
 *
 */
public enum CssProperty {
    COLOR("color"),
    TEXT_ALIGN("text-align"),
    TEXT_DECORATION("text-decoration"),
    TEXT_INDENT("text-indent"),
    TEXT_TRANSFORMATION("text-transformation"),
    LINE_HEIGHT("line-height"),
    LETTER_SPACING("letter-spacing"),
    VERTICAL_ALIGN("vertical-align"),
    WORD_SPACING("word-spacing"),
    FONT("font"),
    FONT_FAMILY("font-family"),
    FONT_SIZE("font-size"),
    FONT_STYLE("font-style"),
    FONT_WEIGHT("font-weight"),
    FONT_VARIANT("font-variant"),
    BG_COLOR("background-color"),
    BG_IMAGE("background-image"),
    BG_REPEAT("background-repeat"),
    BG_POSITION("background-position"),
    BG_ATTACHMENT("background-attachment"),
    LIST_STYLE_TYPE("list-style-type");

    private String s;

    private CssProperty(String s) {
        this.s = s;
    }

    public String get() {
        return s;
    }

}
