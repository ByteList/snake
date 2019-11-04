package de.snake;

import de.snake.menu.SnakeMenu;

/**
 * Created by Niklas Emmrich on 29.10.2019.
 * <p>
 * Copyright by Niklas Emmrich.
 */
public class Snake {

    private static Snake instance;

    public Snake() {
        instance = this;
    }

    public void loadSnakeMenu(SnakeMenu snakeMenu) {

    }

    public static Snake getInstance() {
        return instance;
    }

}
