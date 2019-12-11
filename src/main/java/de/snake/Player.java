package de.snake;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Niklas Emmrich on 29.10.2019.
 * <p>
 * Copyright by Niklas Emmrich.
 */
public class Player {

    private final int id;
    private String displayName;
    private int speed = StaticConstants.NORMAL_SPEED, lineThickness = 3;
    private int x, y;
    private final HashMap<int[], Integer> linePoints = new HashMap<>();
    private Direction direction;
    private boolean alive = true;

    public Player(int id, String displayName, int x, int y, Direction direction) {
        this.id = id;
        this.displayName = displayName;

        this.move(direction);
        this.setXY(x, y);
    }

    public void move(Direction direction) {
        this.direction = direction;
        System.out.println(direction);
    }

    public void setXY(int x, int y) {
        int[] array = new int[] {x, y};

        System.out.println(x+";"+y);

        this.x = x;
        this.y = y;

        if(this.linePoints.containsKey(array)) {
            alive = false;
            return;
        }
        this.linePoints.put(array, this.lineThickness);
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public int getLineThickness() {
        return lineThickness;
    }


    public HashMap<int[], Integer> getLinePoints() {
        return linePoints;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isAlive() {
        return alive;
    }
}
