package GUI.Objects;

import GUI.Entities.Point;

import javax.swing.*;
import java.awt.*;

public class TestFieldButton extends JButton {
    public Point position = new Point();

    protected int type;

    protected int number;

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;

        if (this.type == 1) {
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
}
