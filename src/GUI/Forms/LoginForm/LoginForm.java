package GUI.Forms.LoginForm;

import DBAuthenticator.AuthData;
import GUI.Controllers.DoctorMainMenuController;
import GUI.Controllers.MainMenuFrameController;
import GUI.Controllers.RegisterFrameController;
import GUI.Forms.Constants;
import GUI.Forms.DoctorMainMenu.DoctorMainMenu;
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
    private JButton guestButton;

    public LoginForm() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginTextField.getText();
                String password = passwordTextField.getText();

                if (Authenticator.authUser(login, password)) {
                    AuthData.setUserName(login);
                    JOptionPane.showMessageDialog(new JFrame(), "Login ok");
                    StateManager.destroyForm(Constants.LOGIN_FORM);
                    if (Authenticator.isUserDoctor()) {
                        StateManager.loadController(MainMenuFrameController.class, Constants.MENU_FORM);
                    } else {
                        StateManager.loadController(DoctorMainMenuController.class, Constants.MENU_FORM);
                    }
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

        guestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AuthData.setUserName("guest");
                StateManager.destroyForm(Constants.LOGIN_FORM);
                StateManager.loadController(MainMenuFrameController.class, Constants.MENU_FORM);
            }
        });
    }
}
