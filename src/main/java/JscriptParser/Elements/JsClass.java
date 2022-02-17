package JscriptParser.Elements;

import java.util.LinkedList;

public class JsClass extends StackElement {

    private LinkedList<Function> functions = new LinkedList<>();

    public Function getFunction(String functionName){
        for(Function function:functions){
            if(function.getName().equals(functionName)){
                return function;
            }
        }
        return null;
    }
    public void addFunction(Function function){
        functions.add(function);
    }
    public void removeFunction(Function function){
        this.functions.remove(function);
    }

    public String getBody(){
        String body = "";
        for(Function function : functions){
            body += function.getJs();
        }
        return body;
    }

    @Override
    public String getJs(){
        String jsClass="class "+getName()+"{\n";
        jsClass += getBody();
        jsClass+="}";
        return jsClass;
    }

}
