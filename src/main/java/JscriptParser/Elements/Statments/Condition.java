package JscriptParser.Elements.Statments;

import JscriptParser.Elements.StackElement;

public class Condition extends StackElement {

    private String condition = "";

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String getJs() {
        String js = getName()+"("+condition+"){\n";
        js+=getBody();
        js+="}";
        return js;
    }
}
