
import JscriptParser.*;

import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    static String path="test/Test.js";

    public static void main(String[] args){
        Parser p = new Parser(path);
        p.parse();
        Function say = p.currentClass.getFunction("sayName");

        System.out.println(say.getFunction());

        writeToFile("test/TestP.js",p.currentClass.getJsClass());
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
