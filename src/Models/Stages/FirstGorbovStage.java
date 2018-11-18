package Models.Stages;

import Entities.FieldColor;

public final class FirstGorbovStage extends StageAbstract {

    protected int[] currentNumber = {1, 1};

    protected int currentColor = FieldColor.BLACK;

    protected void switchCurrentColor() {
        if (this.currentColor == FieldColor.BLACK && this.currentNumber[FieldColor.BLACK] == 26) {
            this.currentColor = FieldColor.RED;
        }
    }

    protected void updateCurrentNumber(int color) {
        this.currentNumber[color]++;
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
