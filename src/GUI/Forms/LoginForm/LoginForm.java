package GUI.Forms.LoginForm;

import Authenticator.Authenticator;
import Database.DBConnection;
import Database.DBStatement;

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

                try {
                    DBConnection conn = new DBConnection();
                    conn.open();
                    Authenticator auth = new Authenticator(conn);

                    if (auth.authenticate(login, password)){
                        JOptionPane.showMessageDialog(new JFrame(), "Login correct");
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Login incorrect");
                    }

                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
}
