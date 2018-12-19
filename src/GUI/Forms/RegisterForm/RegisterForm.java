package GUI.Forms.RegisterForm;

import GUI.Controllers.LoginFrameController;
import GUI.Forms.Constants;
import GUI.StateManager;
import Models.Registrator.Registrator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm {
    private JTextField loginField;
    public JPanel panel1;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JTextField surnameField;
    private JTextField nameField;
    private JTextField patronymicField;
    private JTextField birthdayDateField;
    private JComboBox genderBox;

    public RegisterForm() {
        registerButton.addActionListener(e -> {

            String login = loginField.getText();
            String password = passwordField.getText();
            String surname = surnameField.getText();
            String patronymic = patronymicField.getText();
            String name = nameField.getText();
            String dateOfBirth = birthdayDateField.getText();
            String gender = String.valueOf(genderBox.getSelectedItem());


            if (Registrator.registerUser(login, password, name, surname, patronymic, dateOfBirth, gender)) {
                JOptionPane.showMessageDialog(new JFrame(), "Register ok");
                StateManager.loadController(LoginFrameController.class, Constants.LOGIN_FORM);
                StateManager.destroyForm(Constants.REGISTER_FORM);
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Register not ok");
            }
        });
    }
}
