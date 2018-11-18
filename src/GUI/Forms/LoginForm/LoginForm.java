package GUI.Forms.LoginForm;

import GUI.Controllers.MainMenuFrameController;
import GUI.Controllers.RegisterFrameController;
import GUI.Forms.Constants;
import GUI.Forms.MainMenuForm.MainMenu;
import GUI.StateManager;
import Models.Authenticator.Authenticator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

                if (Authenticator.authUser(login, password)) {
                    JOptionPane.showMessageDialog(new JFrame(), "Login ok");
                    StateManager.destroyForm(Constants.LOGIN_FORM);
                    StateManager.loadController(MainMenuFrameController .class, Constants.MENU_FORM);
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Login not ok");
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
