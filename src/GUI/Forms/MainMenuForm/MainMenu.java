package GUI.Forms.MainMenuForm;

import GUI.Controllers.RulesFormController;
import GUI.Controllers.StatsFormController;
import GUI.Forms.Constants;
import GUI.StateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    private JButton StatsButton;
    public JPanel panel1;
    private JButton runTestButton;
    private JButton button3;

    public MainMenu() {
        runTestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StateManager.destroyForm(Constants.MENU_FORM);
                //StateManager.loadController(SquareFormController.class, Constants.TEST_STAGE);
                StateManager.loadController(RulesFormController.class, Constants.RULES_FORM);
            }
        });
        StatsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StateManager.destroyForm(Constants.MENU_FORM);
                StateManager.loadController(StatsFormController.class, Constants.STATS_FORM);
            }
        });
    }
}
