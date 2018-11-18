package GUI.Forms.SquareForm;

import GUI.Objects.TestFieldButton;
import Models.Stages.StageAbstract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;

import static Helpers.Random.getRandomGameField;

public class SquareForm extends JFrame {
    public JPanel panel1;
    private JPanel gamePannel;
    private JPanel interfacePannel;
    private JLabel Time;
    public StageAbstract stage;
    TestFieldButton[][] squareBut;

    public SquareForm(StageAbstract stage) {
        gamePannel.setLayout(new GridLayout(7, 7, 0, 0));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.stage = stage;
        Time.setText("HEREWILLBETIME");
    }

    public void generate() {
        squareBut = new TestFieldButton[7][7];


        int[][][] field = getRandomGameField();
        int width = 100;
        int height = 100;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                squareBut[i][j] = new TestFieldButton();
                squareBut[i][j].setPreferredSize(new Dimension(width, height));
                squareBut[i][j].setLocation(j * width, i * height);
                squareBut[i][j].addActionListener(new FieldButtonController(this.stage));
                squareBut[i][j].position.setPosition(j, i);
                squareBut[i][j].setType(field[i][j][0]);
                squareBut[i][j].setNumber(field[i][j][1]);
                this.gamePannel.add(squareBut[i][j]);
            }
        }
    }

}
