package GUI;

import javax.swing.*;
import java.awt.*;

public class Test1 {
    public JPanel panel1;
    JButton[][] testField;

    public Test1() {
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
    }

    public void generate() {
        //testField = new JButton[7][7];

        for (int i = 0; i < 7; i++)
            for (int j = 0; j < 7; j++) {
                JButton b = new JButton("a");
                b.setSize(20,20);
                this.panel1.add(b);
            }
    }
}
