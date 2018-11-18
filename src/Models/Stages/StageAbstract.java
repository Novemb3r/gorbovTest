package Models.Stages;

/**
 * Абстрактный класс теста. Классы наследники реализуют логику конкретного теста
 */
public abstract class StageAbstract {

    protected static int[] currentNumber;

    protected static int currentColor;

    protected abstract void switchCurrentColor();

    protected abstract void updateCurrentNumber(int color);

    public abstract boolean playersTurn(int number, int color);

}
