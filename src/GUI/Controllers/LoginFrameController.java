package GUI.Controllers;

import GUI.Forms.LoginForm.LoginForm;

import javax.swing.*;
import java.awt.*;

public class LoginFrameController extends DestroyableFrame implements IFormController  {

    @Override
    public void loadForm() {
        this.frame = new JFrame("Логин");
        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(800, 700));
        LoginForm field = new LoginForm();


        frame.setContentPane(field.panel1);

        frame.pack();
        frame.setVisible(true);
    }
}
