package GUI.Controllers;

import GUI.Forms.LoginForm.LoginForm;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class LoginFrameController extends DestroyableFrame implements IFormController  {

    @Override
    public void loadForm() {
        this.frame = new JFrame("Логин");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(800, 700));
        LoginForm field = new LoginForm();


        frame.setContentPane(field.panel1);

        frame.pack();
        frame.setVisible(true);
    }
}
