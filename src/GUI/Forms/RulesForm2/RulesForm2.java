package GUI.Forms.RulesForm2;

import GUI.Controllers.RulesForm2Controller;
import GUI.Controllers.SquareFormController;
import GUI.Forms.Constants;
import GUI.Forms.SquareForm.SquareForm;
import GUI.StateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RulesForm2 {
    private JButton OKButton;
    private JLabel label1;
    public JPanel panel1;

    public RulesForm2() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StateManager.destroyForm(Constants.RULES_FORM_2);
                SquareFormController.startSecondStage();
            }
        });

        label1.setText(Constants.RULES_TEXT_2);
    }
}
