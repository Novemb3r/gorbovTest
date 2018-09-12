import GUI.LoginForm;

import javax.swing.*;

public class GuiExample {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Login");
        frame.setContentPane(new LoginForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
