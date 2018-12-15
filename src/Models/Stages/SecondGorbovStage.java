package Models.Stages;

import Entities.FieldColor;
import GUI.Controllers.SquareFormController;

public final class SecondGorbovStage extends StageAbstract {

    protected int[] currentNumber = {1, 24};

    protected int currentColor = FieldColor.BLACK;

    protected void switchCurrentColor() {
        if (this.currentColor == FieldColor.RED) {
            this.currentColor = FieldColor.BLACK;
        } else {
            this.currentColor = FieldColor.RED;
        }
    }

    protected void updateCurrentNumber(int color) {
        if (color == FieldColor.BLACK) {
            this.currentNumber[color]++;
        } else {
            this.currentNumber[color]--;
        }
    }

    public boolean playersTurn(int number, int color) {
        if (color != this.currentColor || this.currentNumber[color] != number) {
            return false;
        }

        //if (number == 3) {
        if (number == 25 && color == FieldColor.BLACK) {
            SquareFormController.endTest();
        }

        this.updateCurrentNumber(color);
        this.switchCurrentColor();

        return true;
    }

}
