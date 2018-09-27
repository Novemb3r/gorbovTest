package Models.Stages;

import Entities.FieldColor;

public class FirstGorbovStage extends StageAbstract {

    protected int[] currentNumber = {1, 24};

    /**
     * 0 - черное
     * 1 - красное
     * <p>
     * Плохое решение, любые лучшие решения принимаются
     */
    protected int currentColor = FieldColor.BLACK;

    protected void switchCurrentColor() {
        if (this.currentColor == FieldColor.RED) {
            this.currentColor = FieldColor.BLACK;
        } else {
            this.currentColor = FieldColor.RED;
        }
    }

    protected void updateCurrentNumber(int color) {
        if (color == 1) {
            this.currentNumber[color]--;
        } else {
            this.currentNumber[color]++;
        }
    }

    public boolean playersTurn(int number, int color) {
        if (color != this.currentColor || this.currentNumber[color] != number) {
            return false;
        }

        this.updateCurrentNumber(color);
        this.switchCurrentColor();

        return true;
    }

}
