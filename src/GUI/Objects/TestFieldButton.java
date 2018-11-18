package GUI.Objects;

import Entities.FieldColor;
import Entities.Point;

import javax.swing.*;
import java.awt.*;

/**
 * Класс кнопки на поле теста. Слегка дополняет логику обычной JButton
 */
public class TestFieldButton extends JButton {

    public TestFieldButton() {
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial", Font.PLAIN, 40));
    }

    public Point position = new Point();

    protected int type;

    protected int number;

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;

        if (this.type == FieldColor.BLACK) {
            this.setBackground(Color.BLACK);
        } else {
            this.setBackground(Color.RED);
        }
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
        this.setText(Integer.toString(this.number));
    }

    public void markDisabled(){
        this.setEnabled(false);
        this.setBackground(Color.GRAY);
    }
}
