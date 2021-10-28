import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Compiler extends JFrame{
    private JTextPane terminalPane;
    private JTextField inputField;
    private JPanel mainPanel;
    private Evaluator E;
    public Compiler(){
        Utility.__initialization__(this,mainPanel);
        E = new Evaluator();
        inputField.setBorder(new EmptyBorder(10, 10, 10, 10));
        inputField.addActionListener(e -> {
            String input = inputField.getText();
            String result = E.evaluate(input);
            terminalPane.setText(terminalPane.getText() + "\n" + "\tEvaluating " + input + " = " +result);
            inputField.setText("");
            inputField.requestFocus();
        });
    }


    public static void main(String[] args) {
        Compiler C = new Compiler();
        C.setVisible(true);
        C.inputField.requestFocus();
    }
}
