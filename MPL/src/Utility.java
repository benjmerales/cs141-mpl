import javax.swing.*;
import java.awt.*;
import java.net.URL;
interface ColorValues{
    Color MAIN_BG = new Color(0,0,0);
    Color MAIN_FG = new Color(0,143,17);
}
interface Utility {
    static URL getThisResource(String str){
        return Utility.class.getResource("resources/" + str);
    }
    // Initial code for most frames. Includes coloring and setting frame properties
    static void __initialization__(JFrame frame, JPanel panel){
        frame.setContentPane(panel);
        frameProperties(frame);
        frame.setBackground(ColorValues.MAIN_BG);
        panel.setBackground(ColorValues.MAIN_BG);
        styleComponents(panel.getComponents(),ColorValues.MAIN_BG, ColorValues.MAIN_FG);
    }

    // In __initialization__. all frame code
    private static void frameProperties(JFrame frame){
        frame.setIconImage(new ImageIcon(Utility.getThisResource("logo.gif")).getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Honeypot");
        frame.setUndecorated(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    private static void styleComponents(Component[] C, Color background, Color foreground){
        for(Component c: C){
            String name = c.getClass().getName();
            c.setForeground(foreground);
            c.setBackground(background);
        }
    }
}
