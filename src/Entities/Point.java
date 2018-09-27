package Entities;

public class Point {

    protected int positionX;

    protected int positionY;

    public Point() {
    }

    public Point (int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }

    public int getXPosition() {
        return this.positionX;
    }

    public int getYPosition() {
        return this.positionY;
    }

    public int[] getPosition() {
        return new int[]{this.positionX, this.positionY};
    }

    public void setPosition(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }

    public String toString(){
        return "(" + this.positionX + ", " + this.positionY + ")";
    }
}
