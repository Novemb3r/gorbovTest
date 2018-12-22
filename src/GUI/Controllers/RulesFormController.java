package GUI.Controllers;

import GUI.Forms.LoginForm.LoginForm;
import GUI.Forms.RulesForm.RulesForm;

import javax.swing.*;

public class RulesFormController extends DestroyableFrame implements IFormController {

    @Override
    public void loadForm() {
        this.frame = new JFrame("Информация");
        frame.setResizable(false);

        RulesForm field = new RulesForm();


        frame.setContentPane(field.panel1);

        frame.pack();
        frame.setVisible(true);
    }
}
