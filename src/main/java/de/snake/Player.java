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

    public Player(int id, String displayName, double x, double y) {
        this.id = id;
        this.displayName = displayName;
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
}
