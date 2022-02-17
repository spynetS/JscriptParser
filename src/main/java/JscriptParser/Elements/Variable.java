package JscriptParser.Elements;

public class Variable extends JsElement{
    String name;
    String value;
    VariableType type;

    public Variable(){}

    /**
     *
     * @param name name of variable
     * @param value REMEMBER TO PUT ' AROUND YOUR VALE 'value'
     * @param type what type let var const this.
     */
    public Variable(String name, String value, VariableType type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public String getJsDeclarization(){
        return (this.type.value+name+" = "+value+";");
    }
    public String getJs(){
        return (this.type.value+name);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public VariableType getType() {
        return type;
    }

    public void setType(VariableType type) {
        this.type = type;
    }
}
