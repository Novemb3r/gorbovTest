package Models.Stages;

import Entities.FieldColor;
import GUI.Controllers.SquareFormController;
import GUI.Forms.SquareForm.SquareForm;

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

        if (number == 24 && color == FieldColor.RED) {
            SquareFormController.switchStage();
        }

        this.updateCurrentNumber(color);
        this.switchCurrentColor();

        return true;
    }
}
