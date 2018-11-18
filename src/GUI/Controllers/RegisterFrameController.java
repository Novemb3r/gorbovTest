package GUI.Controllers;

import GUI.Forms.LoginForm.LoginForm;
import GUI.Forms.RegisterForm.RegisterForm;

import javax.swing.*;
import java.awt.*;

public class RegisterFrameController extends DestroyableFrame implements IFormController {

    @Override
    public void loadForm() {
        this.frame = new JFrame("Регистрация");
        frame.setResizable(false);
       // frame.setPreferredSize(new Dimension(600, 600));
        RegisterForm field = new RegisterForm();


        frame.setContentPane(field.panel1);

        frame.pack();
        frame.setVisible(true);
    }
}
