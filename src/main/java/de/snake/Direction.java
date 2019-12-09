package de.snake;

/**
 * Created by Niklas Emmrich on 09.12.19.
 * <p>
 * Copyright by Niklas Emmrich.
 */
public enum Direction {

    NORTH(0, +1),
    EAST(+1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);

    private double xVal, yVal;

    Direction(double xVal, double yVal) {
        this.xVal = xVal;
        this.yVal = yVal;
    }

    public double getXVal() {
        return xVal;
    }

    public double getYVal() {
        return yVal;
    }
}
