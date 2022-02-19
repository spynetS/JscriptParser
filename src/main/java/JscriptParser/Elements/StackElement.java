package JscriptParser.Elements;

import java.util.LinkedList;

public class StackElement extends JsElement{

    private String name = ""; //code
    private LinkedList<Variable> variables = new LinkedList<>();
    private LinkedList<JsElement> elements = new LinkedList<>();

    public LinkedList<JsElement> getElements() {
        return elements;
    }

    public void setElements(LinkedList<JsElement> elements) {
        this.elements = elements;
    }

    public LinkedList<Variable> getVariables() {
        return variables;
    }

    public void setVariables(LinkedList<Variable> variables) {
        this.variables = variables;
    }

    public String getBody() {
        String body = "";
        for(JsElement el : elements){
            body+=el.getJs();
        }
        return body;
    }

    public LinkedList<StackElement> getStackelemnts(){
        LinkedList<StackElement> stackElements = new LinkedList<>();
        for(JsElement e : elements){
            try{
                stackElements.add((StackElement) e);
            }catch (Exception error){}
        }
        return stackElements;
    }

    public void addToBody(JsElement body) {
        elements.add(body);
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
