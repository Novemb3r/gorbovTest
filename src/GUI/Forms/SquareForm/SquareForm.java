package GUI.Forms.SquareForm;

import GUI.Objects.TestFieldButton;
import Models.Stages.FirstGorbovStage;
import Models.Stages.SecondGorbovStage;
import Models.Stages.StageAbstract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Helpers.Random.getRandomGameField;

public class SquareForm extends JFrame {
    public JPanel panel1;
    private JPanel gamePannel;
    private JPanel interfacePannel;
    public JLabel Error1;
    private JLabel Error2;
    public StageAbstract stage;
    static TestFieldButton[][] squareBut;
    private Timer fpsTimer;

    private void fps()
    {
        fpsTimer = new Timer(15, new fpsListener());
        fpsTimer.start();
    }

    public class fpsListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

            Error1.setText(FirstGorbovStage.errors.toString());
            Error2.setText(SecondGorbovStage.errors.toString());

        }
    }

    public SquareForm(StageAbstract stage) {
        gamePannel.setLayout(new GridLayout(7, 7, 0, 0));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.stage = stage;
    }

    public void generate() {
        gamePannel.removeAll();
        gamePannel.revalidate();
        gamePannel.repaint();


        squareBut = new TestFieldButton[7][7];


        int[][][] field = getRandomGameField();
        int width = 100;
        int height = 100;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                squareBut[i][j] = new TestFieldButton();
                squareBut[i][j].setPreferredSize(new Dimension(width, height));
                squareBut[i][j].setLocation(j * width, i * height);
                squareBut[i][j].addActionListener(new FieldButtonController(stage));
                squareBut[i][j].position.setPosition(j, i);
                squareBut[i][j].setType(field[i][j][0]);
                squareBut[i][j].setNumber(field[i][j][1]);
                gamePannel.add(squareBut[i][j]);
            }
        }
        fps();
    }

    public Integer getErrors() {
        return stage.getErrors();
    }
}
