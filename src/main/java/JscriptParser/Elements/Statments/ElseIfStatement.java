package JscriptParser.Elements.Statments;

import JscriptParser.Elements.StackElement;

public class ElseIfStatement extends StackElement {

    private String conditions ="";

    public String getConditions() {
        return conditions;
    }
    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    @Override
    public String getJs() {
        String ifstatement = "else if("+conditions+"){\n";
        ifstatement = ifstatement+"\t"+getBody();
        ifstatement = ifstatement+"}\n";

        return ifstatement;
    }
}
