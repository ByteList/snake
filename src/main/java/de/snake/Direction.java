package de.snake;

/**
 * Created by Niklas Emmrich on 09.12.19.
 * <p>
 * Copyright by Niklas Emmrich.
 */
public enum Direction {

    NORTH(0, -1, "WEST", "EAST"),
    EAST(1, 0, "NORTH", "SOUTH"),
    SOUTH(0, 1, "EAST", "WEST"),
    WEST(-1, 0, "SOUTH", "NORTH");

    private int xVal, yVal;
    private String leftDir, rightDir;

    Direction(int xVal, int yVal, String leftDir, String rightDir) {
        this.xVal = xVal;
        this.yVal = yVal;
        this.leftDir = leftDir;
        this.rightDir = rightDir;
    }

    public int getXVal() {
        return xVal;
    }

    public int getYVal() {
        return yVal;
    }

    public Direction getLeftDirection() {
        return Direction.valueOf(leftDir);
    }

    public Direction getRightDirection() {
        return Direction.valueOf(rightDir);
    }
}
