package GUI.Controllers;

import GUI.Forms.LoginForm.LoginForm;
import GUI.Forms.SquareForm.SquareForm;
import Models.Stages.FirstGorbovStage;

import javax.swing.*;
import java.awt.*;

public class LoginFormController implements IFormController  {

    public void loadForm() {
        JFrame frame = new JFrame("Логин");
        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(600, 600));
        LoginForm field = new LoginForm();


        frame.setContentPane(field.panel1);

        frame.pack();
        frame.setVisible(true);
    }
}
