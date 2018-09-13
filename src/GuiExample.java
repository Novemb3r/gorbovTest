import GUI.LoginForm;
import GUI.Test1;

import javax.swing.*;
import java.awt.*;

public class GuiExample {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Test1");
        frame.setPreferredSize(new Dimension(800, 600));
        Test1 field = new Test1();
        frame.setContentPane(field.panel1);
        field.generate();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
