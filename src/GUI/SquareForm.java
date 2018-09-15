package GUI;

import javax.swing.*;
import java.awt.*;

public class SquareForm extends JFrame {
    public JPanel panel1;
    JButton[][] squareBut;

    public SquareForm() {
        panel1.setLayout(new GridLayout(7,7,0,0));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void generate() {
        squareBut = new JButton[7][7];
        int width = 100;
        int height = 100;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                squareBut[i][j]= new JButton();
                squareBut[i][j].setPreferredSize(new Dimension(width,height));
                squareBut[i][j].setLocation(j*width,i*height);
                this.panel1.add(squareBut[i][j]);
            }
        }
    }

}
