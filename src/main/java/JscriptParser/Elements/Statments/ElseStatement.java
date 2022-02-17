package JscriptParser.Elements.Statments;

import JscriptParser.Elements.StackElement;

public class ElseStatement extends StackElement {

    @Override
    public String getJs() {
        return "else{\n"+getBody()+"}\n";
    }
}
