package GUI.Controllers;

import GUI.Forms.LoginForm.LoginForm;
import GUI.Forms.RegisterForm.RegisterForm;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class RegisterFrameController extends DestroyableFrame implements IFormController {

    @Override
    public void loadForm() {
        this.frame = new JFrame("Регистрация");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(800, 700));
        RegisterForm field = new RegisterForm();


        frame.setContentPane(field.panel1);

        frame.pack();
        frame.setVisible(true);
    }
}
