package GUI.Controllers;

import DBAuthenticator.AuthData;
import GUI.Forms.RegisterForm.RegisterForm;
import GUI.Forms.StatsForm;

import javax.swing.*;

public class StatsFormController extends DestroyableFrame implements IFormController {

    @Override
    public void loadForm() {

        this.frame = new JFrame("Статистика пользователя " + AuthData.getUserName());
        frame.setResizable(false);
        // frame.setPreferredSize(new Dimension(600, 600));
        StatsForm field = new StatsForm();


        frame.setContentPane(field.panel1);

        frame.pack();
        frame.setVisible(true);
    }
}
