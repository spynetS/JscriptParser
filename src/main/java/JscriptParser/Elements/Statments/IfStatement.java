package JscriptParser.Elements.Statments;

import JscriptParser.Elements.StackElement;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class IfStatement extends Condition {

    ElseStatement elseStatement;
    LinkedList<ElseIfStatement> elseIfStatements = new LinkedList<>();

    public ElseStatement getElseStatement() {
        return elseStatement;
    }

    public void setElseStatement(ElseStatement elseStatement) {
        this.elseStatement = elseStatement;
    }

    public LinkedList<ElseIfStatement> getElseIfStatements() {
        return elseIfStatements;
    }

    /**
     * Sets the else statment to param
     * @param statement the else statment to be set
     */
    public void addElse(ElseStatement statement){
        elseStatement=(statement);
    }
    public void addElseIf(ElseIfStatement statement){
        elseIfStatements.add(statement);
    }
    public void setElseIfStatements(LinkedList<ElseIfStatement> elseIfStatements) {
        this.elseIfStatements = elseIfStatements;
    }

    public IfStatement() {
        this.setName("if");
    }

    @Override
    public String getJs() {
        String ifstatement = "if("+getCondition()+"){\n";
        ifstatement = ifstatement+"\t"+getBody();
        ifstatement = ifstatement+"}\n";
        for(ElseIfStatement elseIfStatement : elseIfStatements){
            ifstatement+=elseIfStatement.getJs();
        }
        if(elseStatement!=null)
            ifstatement+=elseStatement.getJs();

        return ifstatement;
    }

    /**
     * Cant change name
     * @param name
     */
    @Override
    public void setName(String name) {
        //should not be able to change name
    }
}
