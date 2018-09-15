import GUI.LoginForm;
import GUI.Test1;
import GUI.SquareForm;

import javax.swing.*;
import java.awt.*;

public class GuiExample {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Метод Горбова");
        frame.setPreferredSize(new Dimension(600, 600));
        frame.setResizable(false);
        SquareForm field = new SquareForm();

        field.generate();
        frame.setContentPane(field.panel1);

        frame.pack();
        frame.setVisible(true);
    }
}
