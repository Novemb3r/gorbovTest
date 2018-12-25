package GUI.Controllers;

import GUI.Forms.LoginForm.LoginForm;
import GUI.Forms.InterpretationForm.InterpretationForm;
import GUI.Forms.RulesForm.RulesForm;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class InterpretationController extends DestroyableFrame implements IFormController  {

    @Override
    public void loadForm() {
        frame = new JFrame("Интерпретация последнего результата");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setResizable(false);

        InterpretationForm field = new InterpretationForm();

        frame.setPreferredSize(new Dimension(800, 700));
        frame.setContentPane(field.panel1);

        frame.pack();
        frame.setVisible(true);
    }
}
