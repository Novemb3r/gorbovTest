package GUI.Controllers;

import GUI.Forms.LoginForm.LoginForm;
import GUI.Forms.ResultForm.ResultForm;
import GUI.Forms.RulesForm.RulesForm;

import javax.swing.*;
import java.awt.*;

public class ResultFormController extends DestroyableFrame implements IFormController {

    @Override
    public void loadForm() {
        frame = new JFrame("Результаты");
        frame.setResizable(false);

        ResultForm field = new ResultForm();

        frame.setPreferredSize(new Dimension(800, 700));
        frame.setContentPane(field.panel1);

        frame.pack();
        frame.setVisible(true);
    }
}
