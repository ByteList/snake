package de.snake;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by Niklas Emmrich on 29.10.2019.
 * <p>
 * Copyright by Niklas Emmrich.
 */
public class Player {

    private final Snake snake = Snake.getInstance();

    private final int id;
    private String displayName;
    private int speed = StaticConstants.NORMAL_SPEED, lineThickness = 7;
    private Color lineColor = Color.RED;
    private int x, y;
    private final HashMap<String, Integer> linePoints = new HashMap<>();
    private Direction direction = Direction.EAST;
    private boolean alive = true;
    private Image snakeHead;
    private int selected;

    public Player(int id, String displayName, int selected) {
        this.id = id;
        this.displayName = displayName;
        this.selected = selected;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
        System.out.println(direction);
    }

    public void setXY(int x, int y) {
        String point = x+";"+y;

        System.out.println(point);

        this.x = x;
        this.y = y;

        if(snake.getCurrentGame() != null && (snake.getCurrentGame().getLinePoints().containsKey(point) ||
                x > snake.getCurrentGame().getSnakeMap().getWidth() ||
                y > snake.getCurrentGame().getSnakeMap().getHeight() ||
                x < 0 || y < 0)) {
            alive = false;
            return;
        }
        this.linePoints.put(point, this.lineThickness);
        if(snake.getCurrentGame() != null)
            snake.getCurrentGame().addLinePoint(point, this.lineThickness);
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

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public HashMap<String, Integer> getLinePoints() {
        return new HashMap<>(linePoints);
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isAlive() {
        return alive;
    }

    public Image getSnakeHead() {
        return snakeHead;
    }

    public void setSnakeHead(Image snakeHead) {
        this.snakeHead = snakeHead;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }
}
