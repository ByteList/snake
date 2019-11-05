package de.snake;

import de.snake.menu.SnakeMenu;

import java.util.ArrayList;

/**
 * Created by Niklas Emmrich on 29.10.2019.
 * <p>
 * Copyright by Niklas Emmrich.
 */
public class Snake {

    private static Snake instance;

    private final ArrayList<Game> games = new ArrayList<>();
    private Game currentGame;


    public Snake() {
        instance = this;
    }

    public void loadSnakeMenu(SnakeMenu snakeMenu) {

    }

    public static Snake getInstance() {
        return instance;
    }

}
