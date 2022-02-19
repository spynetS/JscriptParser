package JscriptParser;

import JscriptParser.Elements.Function;
import JscriptParser.Elements.JsClass;
import JscriptParser.Elements.JsElement;
import JscriptParser.Elements.Statments.Condition;
import JscriptParser.Elements.Statments.IfStatement;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Parser {
    private String path = "";

    public JsClass currentClass;

    public Parser(String path) {
        this.path = path;
    }

    private String nextLine(Scanner scanner){
        return scanner.nextLine();
    }

    private void addFunctionToCurrentClass(String functionLine,List<String> lines,int from){
        System.out.println("new");
        Function newFunction = new Function();
        newFunction.setName(functionLine.substring(0,functionLine.indexOf("(")).replace(" ",""));
        newFunction.setArguments(functionLine.substring(functionLine.indexOf("(")+1,functionLine.indexOf(")")));
        String body = "";
        Condition currentConditon = null;
        int count = 0; // to see if the curly bracket belongs to the function
        for(int i = from;i<lines.size();i++) {
            String data = lines.get(i);
            if(data.contains("{")){
                count++;
            }
            if(data.contains("}")&&count<=0) {
                break;
            }
            else{
                count-=1;
            }
            if(data.contains("(")&&data.contains(")")){
                String conditionString = data.substring(data.indexOf('(')+1,data.indexOf(')'));
                if(lines.get(i+1).replace(" ","").equals("{")&&!data.replace(conditionString,"").contains(";")){
                    //it is a function bro
                    Condition condition = new Condition();
                    condition.setName(data.substring(0,data.indexOf("(")).replace(" ",""));
                    condition.setCondition(conditionString);
                    currentConditon=condition;
                    continue;
                }
                else if(data.contains("{")){
                    Condition condition = new Condition();
                    condition.setName(data.substring(0,data.indexOf("(")).replace(" ",""));
                    condition.setCondition(conditionString);
                    currentConditon=condition;
                    continue;
                }
                else if (currentConditon==null){
                    newFunction.addToBody(new JsElement(data+"\n"));
                }
            }
            else {
                newFunction.addToBody(new JsElement(data+"\n"));
            }

            if(currentConditon!=null){
                currentConditon.addToBody(new JsElement(data));
                newFunction.addToBody(currentConditon);
                currentConditon = null;
            }

        }
        currentClass.addFunction(newFunction);
    }

    public void parse() {
        try{
            List<String> lines = Files.readAllLines(Paths.get(path));
            boolean isInClass = false;

            for(int i = 0;i<lines.size();i++){
                String data = lines.get(i);

                if(data.contains("class")){
                    JsClass classComp =new JsClass();
                    classComp.setName(data.replace("class","").substring(0,data.replace("class","").length()-1).replace(" ",""));
                    currentClass = classComp;
                    isInClass = true;
                }
                if(isInClass&&!data.contains("if")){
                    if(data.contains("(")&&data.contains(")")){
                        String conditionString = data.substring(data.indexOf('(')+1,data.indexOf(')'));
                        if(lines.get(i+1).replace(" ","").equals("{")&&!data.replace(conditionString,"").contains(";")){
                            //it is a function bro
                            addFunctionToCurrentClass(data,lines,i+2);
                        }
                        else if(data.contains("{")){
                            //here to
                            addFunctionToCurrentClass(data,lines,i+1);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       currentClass.getBody();
    }
}
