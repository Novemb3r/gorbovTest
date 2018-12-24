package GUI.Forms.ResultForm;

import GUI.Controllers.MainMenuFrameController;
import GUI.Controllers.SquareFormController;
import GUI.Forms.Constants;
import GUI.Forms.SquareForm.SquareForm;
import GUI.StateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultForm {
    public JPanel panel1;
    private JButton OKButton;
    private JLabel Title;
    private JLabel labelErr1;
    private JLabel labelErr2;
    private JLabel labelTime1;
    private JLabel labelTime2;
    private JLabel labelTimeAll;


    public ResultForm() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                StateManager.destroyForm(Constants.RESULT_FORM);
                StateManager.loadController(MainMenuFrameController.class, Constants.MENU_FORM);
            }
        });
        labelErr1.setText(SquareFormController.errorsOnFirstStage.toString());
        labelErr2.setText(SquareFormController.errorsOnSecondStage.toString());
        Long timeFirstStage = SquareFormController.dateEndFirstStage - SquareFormController.dateBeginFirstStage;
        labelTime1.setText(timeFirstStage.toString());
        Long timeSecondStage = SquareFormController.dateEndSecondStage - SquareFormController.dateBeginSecondStage;
        labelTime2.setText(timeSecondStage.toString());
        Long timeDiffStage = timeSecondStage - timeFirstStage;
        labelTimeAll.setText(timeDiffStage.toString());
    }
}
