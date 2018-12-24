package GUI.Controllers;

import DBAuthenticator.AuthData;
import GUI.Forms.DoctorStatsForm.DoctorStatsForm;

import javax.swing.*;

public class DoctorStatsFormController extends DestroyableFrame implements IFormController {
    @Override
    public void loadForm() {

        this.frame = new JFrame("Статистика пользователя " + AuthData.getUserName());
        frame.setResizable(false);
        // frame.setPreferredSize(new Dimension(600, 600));
        DoctorStatsForm field = new DoctorStatsForm();


        frame.setContentPane(field.panel1);

        frame.pack();
        frame.setVisible(true);
    }
}
