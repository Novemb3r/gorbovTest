package GUI.Forms.LoginForm;

import Authenticator.Authenticator;
import Database.DBConnection;
import Database.DBStatement;
import GUI.Controllers.RegisterFrameController;
import GUI.Forms.Constants;
import GUI.StateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputFilter;

public class LoginForm extends JFrame {
    public JPanel panel1;
    private JTextField loginTextField;
    private JPasswordField passwordTextField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginForm() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginTextField.getText();
                String password = passwordTextField.getText();

                try {
                    Authenticator auth = new Authenticator();

                    if (auth.authenticate(login, password)){
                        JOptionPane.showMessageDialog(new JFrame(), "Login ok");
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Login ok");
                    }

                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });


        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StateManager.destroyForm(Constants.LOGIN_FORM);
                StateManager.loadController(RegisterFrameController.class, Constants.REGISTER_FORM);
            }
        });
    }
}
