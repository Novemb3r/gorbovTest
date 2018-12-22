package GUI.Forms.RulesForm;

import GUI.Controllers.SquareFormController;
import GUI.Forms.Constants;
import GUI.StateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RulesForm {
    public JPanel panel1;
    private JButton button1;
    private JLabel label1;

    public RulesForm() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StateManager.destroyForm(Constants.RULES_FORM);
                StateManager.loadController(SquareFormController.class, Constants.TEST_STAGE);
            }
        });

        label1.setText(Constants.RULES_TEXT_1);

    }
}
