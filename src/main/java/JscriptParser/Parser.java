package JscriptParser;

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
        Function newFunction = new Function();
        newFunction.setName(functionLine.substring(0,functionLine.indexOf("(")).replace(" ",""));
        String body = "";
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
            body+=data+"\n";
        }
        newFunction.addBody(body);
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
                if(isInClass){
                    if(data.contains("(")&&data.contains(")")){

                        if(lines.get(i+1).contains("{")){
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
