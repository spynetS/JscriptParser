package JscriptParser;

public class Function extends Element {
    private String body = ""; //code


    public void addBody(String content){
        this.body+="\n"+content;
    }
    public void removeBody(String body){
        this.body.replace(body,"");
    }

    public String getBody(){
        return body;
    }
    public String getFunction(){
        String func = this.getName()+"(){";
        func = func+"\t"+getBody();
        func = func+"}";
        return func;
    }

    @Override
    public String toString() {
        return "Function{"+getName()+"}";
    }
}
