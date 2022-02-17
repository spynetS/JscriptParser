
import JscriptParser.*;
import JscriptParser.Elements.Function;
import JscriptParser.Elements.JsElement;
import JscriptParser.Elements.Statments.ElseIfStatement;
import JscriptParser.Elements.Statments.ElseStatement;
import JscriptParser.Elements.Statments.IfStatement;
import JscriptParser.Elements.Variable;
import JscriptParser.Elements.VariableType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    static String path="test/Test.js";

    public static void main(String[] args){

        Parser p = new Parser(path);
        p.parse();
        Function say = p.currentClass.getFunction("sayName");
        Variable var = new Variable("test","test",VariableType.THIS);
        say.addToBody(var);
        say.addToBody(new JsElement("knas"));


        writeToFile("test/TestP.js",p.currentClass.getJs());
    }

    static void writeToFile(String path,String toWrite){
        try {
            File myObj = new File(path);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(toWrite);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
