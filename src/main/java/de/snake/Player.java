package de.snake;

import java.util.ArrayList;

/**
 * Created by Niklas Emmrich on 29.10.2019.
 * <p>
 * Copyright by Niklas Emmrich.
 */
public class Player {

    private final int id;
    private String displayName;
    private double x, y, speed = StaticConstants.NORMAL_SPEED, lineThickness = 3;
    private final ArrayList<double[]> linePoints = new ArrayList<>();
    private final int leftKey, rightKey;
    private Direction direction;
    private boolean directionLocked = false;

    public Player(int id, String displayName, double x, double y, Direction direction, int leftKey, int rightKey) {
        this.id = id;
        this.displayName = displayName;
        this.x = x;
        this.y = y;
        this.leftKey = leftKey;
        this.rightKey = rightKey;
        this.direction = direction;
    }

    public void move(Direction direction) {
        this.direction = direction;
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSpeed() {
        return speed;
    }

    public double getLineThickness() {
        return lineThickness;
    }


    public ArrayList<double[]> getLinePoints() {
        return linePoints;
    }

    public int getRightKey() {
        return rightKey;
    }

    public int getLeftKey() {
        return leftKey;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isDirectionLocked() {
        return directionLocked;
    }

    public void setDirectionLocked(boolean directionLocked) {
        this.directionLocked = directionLocked;
    }
}
