package JscriptParser.Elements;

import java.util.LinkedList;

public class JsElement {

    private LinkedList<JsElement> elements = new LinkedList<>();
    String js = "";

    public JsElement() {
    }

    public JsElement(String js) {
        this.js = js;
    }

    public void setJs(String js) {
        this.js = js;
    }

    public LinkedList<JsElement> getElements() {
        return elements;
    }
    public void setElements(LinkedList<JsElement> elements) {
        this.elements = elements;
    }
    public void removeElement(JsElement element){
        this.elements.remove(element);
    }
    public String getJs(){
        return js;
    }

}
