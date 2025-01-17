
package com.Forsys.ui.actions;

/**
 * Commonly used html attributes
 * 
 *
 */
public enum Attributes {
    ACCEPT("accept"),
    ACCEPT_CHARSET("accept-charset"),
    ACCESSKEY("accesskey"),
    ACTION("action"),
    ALIGN("align"),
    ALT("alt"),
    ASYNC("async"),
    AUTO_COMPLETE("autocomplete"),
    AUTO_FOCUS("autofocus"),
    AUTO_PLAY("autoplay"),
    AUTO_SAVE("autosave"),
    BG_COLOR("bgcolor"),
    BORDER("border"),
    BUFFERED("buffered"),
    CHALLENGE("challenge"),
    CHARSET("charset"),
    CHECKED("checked"),
    CITE("cite"),
    CLASS("class"),
    CODE("code"),
    CODE_BASE("codebase"),
    COLOR("color"),
    COLS("cols"),
    COLSPAN("colspan"),
    CONTENT("content"),
    CONTENT_EDITABLE("contenteditable"),
    CONTEXT_MENU("contextmenu"),
    CONTROLS("controls"),
    COORDS("coords"),
    DATA("data"),
    DATA_STAR("data-*"),
    DATE_TIME("datetime"),
    DEFAULT("default"),
    DEFER("defer"),
    DIR("dir"),
    DIR_NAME("dirname"),
    DISABLED("disabled"),
    DOWNLOAD("download"),
    DRAGGABLE("draggable"),
    DROPZONE("dropzone"),
    ENCTYPE("enctype"),
    FOR("for"),
    FORM("form"),
    FORM_ACTION("formaction"),
    HEADERS("headers"),
    HEIGHT("height"),
    HIDDEN("hidden"),
    HIGH("high"),
    HREF("href"),
    HREF_LANG("hreflang"),
    HTTP_EQUIV("http-equiv"),
    ICON("icon"),
    ID("id"),
    ISMAP("ismap"),
    ITEM_PROP("itemprop"),
    KEY_TYPE("keytype"),
    KIND("kind"),
    LABEL("label"),
    LANG("lang"),
    LANGUAGE("language"),
    LIST("list"),
    LOOP("loop"),
    LOW("low"),
    MANIFEST("manifest"),
    MAX("max"),
    MAXLENGTH("maxlength"),
    MEDIA("media"),
    METHOD("method"),
    MIN("min"),
    MULTIPLE("multiple"),
    NAME("name"),
    NO_VALIDATE("novalidate"),
    OPEN("open"),
    OPTIMUM("optimum"),
    PATTERN("pattern"),
    PING("ping"),
    PLACEHOLDER("placeholder"),
    POSTER("poster"),
    PRELOAD("preload"),
    PUBDATE("pubdate"),
    RADIO_GROUP("radiogroup"),
    READONLY("readonly"),
    REL("rel"),
    REQUIRED("required"),
    REVERSED("reversed"),
    ROWS("rows"),
    ROW_SPAN("rowspan"),
    SANDBOX("sandbox"),
    SPELL_CHECK("spellcheck"),
    SCOPE("scope"),
    SCOPED("scoped"),
    SEAMLESS("seamless"),
    SELECTED("selected"),
    SHAPE("shape"),
    SIZE("size"),
    SIZES("sizes"),
    SPAN("span"),
    SRC("src"),
    SRC_DOC("srcdoc"),
    SRC_LANG("srclang"),
    START("start"),
    STEP("step"),
    STYLE("style"),
    SUMMARY("summary"),
    TAB_INDEX("tabindex"),
    TARGET("target"),
    TITLE("title"),
    TYPE("type"),
    USE_MAP("usemap"),
    VALUE("value"),
    WIDTH("width"),
    WRAP("wrap"),
    AUTO_ID("autoid");

    private String s;

    private Attributes(String s) {
        this.s = s;
    }

    public String get() {
        return s;
    }

}
