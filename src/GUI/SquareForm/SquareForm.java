package GUI.SquareForm;

import GUI.Objects.TestFieldButton;

import javax.swing.*;
import java.awt.*;

public class SquareForm extends JFrame {
    public JPanel panel1;
    TestFieldButton[][] squareBut;

    public SquareForm() {
        panel1.setLayout(new GridLayout(7, 7, 0, 0));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void generate() {
        squareBut = new TestFieldButton[7][7];
        int width = 100;
        int height = 100;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                squareBut[i][j] = new TestFieldButton();
                squareBut[i][j].setPreferredSize(new Dimension(width, height));
                squareBut[i][j].setLocation(j * width, i * height);
                squareBut[i][j].addActionListener(new FieldButtonController());
                squareBut[i][j].position.setPosition(j, i);
                this.panel1.add(squareBut[i][j]);
            }
        }
    }

}
