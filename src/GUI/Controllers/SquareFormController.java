package GUI.Controllers;

import DBAuthenticator.AuthData;
import DBResults.Results;
import Database.DBException;
import GUI.Forms.SquareForm.SquareForm;
import Helpers.Time;
import Models.Stages.FirstGorbovStage;
import Models.Stages.SecondGorbovStage;

import javax.swing.*;
import java.awt.*;

public class SquareFormController extends DestroyableFrame implements IFormController {

    public static SquareForm field;

    static Long dateBeginFirstStage, dateEndFirstStage, dateBeginSecondStage, dateEndSecondStage;

    @Override
    public void loadForm() {
        this.frame = new JFrame("Метод Горбова");
        //this.frame.setPreferredSize(new Dimension(600, 600));
        this.frame.setResizable(false);
        field = new SquareForm(new FirstGorbovStage());
        dateBeginFirstStage = Time.getTimestamp();
        field.generate();
        this.frame.setContentPane(field.panel1);

        this.frame.pack();
        this.frame.setVisible(true);
    }

    public static void switchStage() {
        dateEndFirstStage = Time.getTimestamp();
        dateBeginSecondStage = Time.getTimestamp();

        field.stage = new SecondGorbovStage();
        field.generate();
    }

    public static void endTest() {
        dateEndSecondStage = Time.getTimestamp();

        try {
            Results.send(
                    AuthData.getUserName(),
                    dateBeginFirstStage,
                    dateEndFirstStage,
                    dateBeginSecondStage,
                    dateEndSecondStage
            );
        } catch (DBException e) {
            e.printStackTrace();
        }
    }
}