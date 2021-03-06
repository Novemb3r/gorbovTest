package Models.Stages;

import Entities.FieldColor;
import GUI.Controllers.SquareFormController;
import GUI.Forms.SquareForm.SquareForm;

public final class FirstGorbovStage extends StageAbstract {

    public static Integer errors = 0;

    protected int[] currentNumber = {1, 25};

    protected int currentColor = FieldColor.BLACK;

    protected void switchCurrentColor() {
        if (this.currentColor == FieldColor.BLACK && this.currentNumber[FieldColor.BLACK] == 25) {
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
            this.errors++;
            //SquareForm..setText(this.errors.toString());
            return false;
        }

        //if (number == 3) {
        if (number == 1 && color == FieldColor.RED) {
            SquareFormController.switchStage();
        }

        this.updateCurrentNumber(color);
        this.switchCurrentColor();

        return true;
    }

    @Override
    public Integer getErrors() {
        return this.errors;
    }
}
