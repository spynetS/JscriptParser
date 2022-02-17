package JscriptParser.Elements;

import java.util.LinkedList;

public class StackElement extends JsElement{

    private String name = ""; //code
    private String body = ""; //code
    private LinkedList<Variable> variables = new LinkedList<>();


    public LinkedList<Variable> getVariables() {
        return variables;
    }

    public void setVariables(LinkedList<Variable> variables) {
        this.variables = variables;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public void addToBody(String body) {
        this.body += body+"\n";
    }
    public void addToBody(JsElement body) {
        this.body += body.getJs()+"\n";
    }
    public void removeFromBody(String body){
        this.body.replace(body,"");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getJs() {
        return super.getJs();
    }
}
