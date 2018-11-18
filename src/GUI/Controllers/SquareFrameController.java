package GUI.Controllers;

import GUI.Forms.SquareForm.SquareForm;
import Models.Stages.FirstGorbovStage;

import javax.swing.*;
import java.awt.*;

public class SquareFrameController extends DestroyableFrame implements IFormController {

    @Override
    public void loadForm() {
        this.frame = new JFrame("Метод Горбова");
        this.frame.setPreferredSize(new Dimension(600, 600));
        this.frame.setResizable(false);
        SquareForm field = new SquareForm(new FirstGorbovStage());

        field.generate();
        this.frame.setContentPane(field.panel1);

        this.frame.pack();
        this.frame.setVisible(true);
    }
}
