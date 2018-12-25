package GUI.Controllers;

import DBAuthenticator.AuthData;
import DBResults.Results;
import Database.DBException;
import GUI.Forms.Constants;
import GUI.Forms.SquareForm.SquareForm;
import GUI.StateManager;
import Helpers.Time;
import Models.Stages.FirstGorbovStage;
import Models.Stages.SecondGorbovStage;

import javax.swing.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class SquareFormController extends DestroyableFrame implements IFormController {

   public static JFrame storedFrame;

    public static SquareForm field;

    public static Long dateBeginFirstStage, dateEndFirstStage, dateBeginSecondStage, dateEndSecondStage;

    public static Integer errorsOnFirstStage, errorsOnSecondStage;

    @Override
    public void loadForm() {
        frame = new JFrame("Метод Горбова");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        frame.setResizable(false);
        field = new SquareForm(new FirstGorbovStage());
        dateBeginFirstStage = Time.getTimestamp();
        field.generate();
        frame.setContentPane(field.panel1);

        frame.pack();
        frame.setVisible(true);
    }

    public static void switchStage() {
        dateEndFirstStage = Time.getTimestamp();

        errorsOnFirstStage = field.getErrors();
        storedFrame = frame;
        storedFrame.setVisible(false);
        //frame.setVisible(false);
        StateManager.loadController(RulesForm2Controller.class, Constants.RULES_FORM_2);


    }

    public static void startSecondStage() {
        storedFrame.setVisible(true);
        dateBeginSecondStage = Time.getTimestamp();
        field.stage = new SecondGorbovStage();
        field.generate();
    }

    public static void endTest() {
        dateEndSecondStage = Time.getTimestamp();
        errorsOnSecondStage = field.getErrors();

        try {
            Results.send(
                    AuthData.getUserName(),
                    dateBeginFirstStage,
                    dateEndFirstStage,
                    dateBeginSecondStage,
                    dateEndSecondStage,
                    errorsOnFirstStage,
                    errorsOnSecondStage
            );
        } catch (DBException e) {
            e.printStackTrace();
        }
        StateManager.destroyForm(Constants.TEST_STAGE);
        storedFrame.dispose();
        StateManager.loadController(ResultFormController.class, Constants.RESULT_FORM);
    }
}
