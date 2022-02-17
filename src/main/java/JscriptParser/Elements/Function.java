package JscriptParser.Elements;

import java.util.LinkedList;

public class Function extends StackElement {
    private String arguments ="";
    private LinkedList<String> returns;

    public LinkedList<String> getReturns() {
        return returns;
    }
    public void setReturns(LinkedList<String> returns) {
        this.returns = returns;
    }

    public String getArguments() {
        return arguments;
    }
    public void setArguments(String arguments) {
        this.arguments = arguments;
    }
    @Override
    public String getJs(){
        String func = this.getName()+"("+getArguments()+"){";
        func = func+"\t"+getBody();
        func = func+"}";
        return func;
    }

    @Override
    public String toString() {
        return "Function{"+getName()+"}";
    }
}
