package GUI.Forms.RegisterForm;

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
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String login = loginField.getText();
                String password = passwordField.getText();
                String surname = surnameField.getText();
                String patronym = patronymicField.getText();
                String name = nameField.getText();
                String dateOfBirth = birthdayDateField.getText();
                String gender = String.valueOf(genderBox.getSelectedItem());


                if (Registrator.registerUser(login, password, name, surname, patronym, dateOfBirth, gender)) {
                    JOptionPane.showMessageDialog(new JFrame(), "Login ok");
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Login ok");
                }
            }
        });
    }
}
