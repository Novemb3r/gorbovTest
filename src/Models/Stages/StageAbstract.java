package Models.Stages;

public abstract class StageAbstract {

    protected int[] currentNumber;

    /**
     * 0 - черное
     * 1 - красное
     * <p>
     * Плохое решение, любые лучшие решения принимаются
     */
    protected int currentColor;

    protected abstract void switchCurrentColor();

    protected abstract void updateCurrentNumber(int color);

    public abstract boolean playersTurn(int number, int color);

}
