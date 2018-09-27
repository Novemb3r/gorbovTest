package GUI.Controllers;

import GUI.Forms.SquareForm.SquareForm;
import Models.Stages.FirstGorbovStage;

import javax.swing.*;
import java.awt.*;

public class SquareFormController implements IFormController {
    
    public void loadForm() {
        JFrame frame = new JFrame("Метод Горбова");
        frame.setPreferredSize(new Dimension(600, 600));
        frame.setResizable(false);
        SquareForm field = new SquareForm(new FirstGorbovStage());

        field.generate();
        frame.setContentPane(field.panel1);

        frame.pack();
        frame.setVisible(true);
    }
}
