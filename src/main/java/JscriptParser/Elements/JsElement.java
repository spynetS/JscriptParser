package JscriptParser.Elements;

import java.util.LinkedList;

public class JsElement {

    String js = "";

    public JsElement() {
    }

    public JsElement(String js) {
        this.js = js+"\n";
    }

    public void setJs(String js) {
        this.js = js;
    }


    public String getJs(){
        return js;
    }

}
