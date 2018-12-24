package GUI.Controllers;

import GUI.Forms.RulesForm2.RulesForm2;

import javax.swing.*;

import java.awt.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class RulesForm2Controller extends DestroyableFrame implements IFormController {

   // public static JFrame frame;
    @Override
    public void loadForm() {
        frame = new JFrame("Информация");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(800,700));
        RulesForm2 field = new RulesForm2();


        frame.setContentPane(field.panel1);

        frame.pack();
        frame.setVisible(true);
    }

}
