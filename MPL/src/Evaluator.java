import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Evaluator {

    public boolean check(String expression1, String expression2){
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String result1 = "";
        String result2 = "";
        try{
            result1 = engine.eval(expression1).toString();
            result2 = engine.eval(expression2).toString();
        }catch(ScriptException e){
            e.printStackTrace();
            System.exit(-1);
        }
        return result1.equals(result2);
    }
    public String evaluate(String expression){
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String result = "";
        try{
            result = engine.eval(expression).toString();
        }catch(ScriptException e){
            e.printStackTrace();
            System.exit(-1);
        }
        return result;
    }
    public static void main(String[] args) {
        Evaluator CC = new Evaluator();
//        System.out.println(CC.evaluate("56*23"));
        System.out.println(CC.check("1+2","2+2"));
    }
}
