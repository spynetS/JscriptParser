package JscriptParser.Elements;

public enum VariableType {
    LET("let "),
    CONST("const "),
    VAR("var "),
    THIS("this.");

    public final String value;
    VariableType(String s) {
        this.value = s;
    }
}
