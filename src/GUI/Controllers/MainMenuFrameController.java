package GUI.Controllers;

import GUI.Forms.MainMenuForm.MainMenu;
import GUI.Forms.RegisterForm.RegisterForm;

import javax.swing.*;
import java.awt.*;

public class MainMenuFrameController extends DestroyableFrame implements IFormController {

    @Override
    public void loadForm() {
        this.frame = new JFrame("Главное меню");
        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(600, 600));
        MainMenu field = new MainMenu();


        frame.setContentPane(field.panel1);

        frame.pack();
        frame.setVisible(true);
    }
}
