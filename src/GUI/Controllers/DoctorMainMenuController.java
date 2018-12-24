package GUI.Controllers;

import DBAuthenticator.AuthData;
import GUI.Forms.DoctorMainMenu.DoctorMainMenu;
import GUI.Forms.MainMenuForm.MainMenu;

import javax.swing.*;
import java.awt.*;

public class DoctorMainMenuController extends DestroyableFrame implements IFormController {

    @Override
    public void loadForm() {
        this.frame = new JFrame("Главное меню");
        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(800, 700));
        DoctorMainMenu field = new DoctorMainMenu();

        if (AuthData.getUserName() == "guest")
            field.nameUser.setText("гостя");
        else field.nameUser.setText(AuthData.getUserName());
        frame.setContentPane(field.panel1);

        frame.pack();
        frame.setVisible(true);
    }

}
