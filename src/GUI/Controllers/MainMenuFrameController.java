package GUI.Controllers;

import GUI.Forms.MainMenuForm.MainMenu;
import GUI.Forms.RegisterForm.RegisterForm;
import DBAuthenticator.AuthData;

import javax.swing.*;
import java.awt.*;

public class MainMenuFrameController extends DestroyableFrame implements IFormController {

    @Override
    public void loadForm() {
        this.frame = new JFrame("Главное меню");
        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(800, 700));
        MainMenu field = new MainMenu();

        if (AuthData.getUserName() == "guest")
               field.nameUser.setText("гостя");
        else field.nameUser.setText("тестируемого   "+AuthData.getUserName());
        frame.setContentPane(field.panel1);

        frame.pack();
        frame.setVisible(true);
    }
}
