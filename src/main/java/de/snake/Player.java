package de.snake;

import java.util.ArrayList;

/**
 * Created by Niklas Emmrich on 29.10.2019.
 * <p>
 * Copyright by Niklas Emmrich.
 */
public class Player {
    private double x, y, speed = 0.3, lineThickness = 3;
    private final int id;
    private String displayName;
    private final ArrayList<double[]> linePoints = new ArrayList<>();

    public Player(double x, double y, double speed, double lineThickness, int id, String displayName) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.lineThickness = lineThickness;
        this.id = id;
        this.displayName = displayName;
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

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public ArrayList<double[]> getLinePoints() {
        return linePoints;
    }
}
