import javax.naming.Name;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameChecker {
    private String name;
    public NameChecker(String name){
        this.name = name;
    }
    private boolean isStringInt(char c) {
        try {
            Integer.parseInt(c + "");
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    private boolean hasSpecialCharacter(){
        Pattern p = Pattern.compile("[^a-z0-9_]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(name);
        boolean b = m.find();
        return b;
    }
    private boolean isFirstInteger(){
        return (isStringInt(name.charAt(0)));
    }
    private boolean isFirstUnder(){
        return (name.charAt(0) == '_');
    }

    private boolean CHECK(){
        return !hasSpecialCharacter() && !isFirstInteger() && !isFirstUnder();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        NameChecker NC = new NameChecker("Test_");
        System.out.println(NC.CHECK()); // outputs true

        NC.setName("X");
        System.out.println(NC.CHECK()); // outputs true

        NC.setName("1");
        System.out.println(NC.CHECK()); // outputs false

        NC.setName("Count_1");
        System.out.println(NC.CHECK()); // outputs true

        NC.setName("_count");
        System.out.println(NC.CHECK()); // outputs false

        NC.setName("Count_");
        System.out.println(NC.CHECK()); // outputs true

        NC.setName("sample");
        System.out.println(NC.CHECK()); // outputs false

        NC.setName("sample*");
        System.out.println(NC.CHECK()); // outputs true

        NC.setName("foo10");
        System.out.println(NC.CHECK()); // outputs false

        NC.setName("10foo");
        System.out.println(NC.CHECK()); // outputs true

        NC.setName("foo10");
        System.out.println(NC.CHECK()); // outputs false
    }
}
