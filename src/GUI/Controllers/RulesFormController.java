package GUI.Controllers;

import GUI.Forms.LoginForm.LoginForm;
import GUI.Forms.RulesForm.RulesForm;

import javax.swing.*;

import java.awt.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class RulesFormController extends DestroyableFrame implements IFormController {

    @Override
    public void loadForm() {
        frame = new JFrame("Информация");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 700));
        frame.setResizable(false);

        RulesForm field = new RulesForm();


        frame.setContentPane(field.panel1);

        frame.pack();
        frame.setVisible(true);
    }
}
