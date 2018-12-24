package GUI.Controllers;

import DBAuthenticator.AuthData;
import GUI.Forms.StatsForm;

import javax.swing.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class StatsFormController extends DestroyableFrame implements IFormController {

    @Override
    public void loadForm() {

        frame = new JFrame("Статистика пользователя " + AuthData.getUserName());
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        // frame.setPreferredSize(new Dimension(600, 600));
        StatsForm field = new StatsForm();


        frame.setContentPane(field.panel1);

        frame.pack();
        frame.setVisible(true);
    }
}
