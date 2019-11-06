package de.snake.bootstrap;

import de.snake.Snake;
import de.snake.menu.StartMenu;

/**
 * Created by Niklas Emmrich on 29.10.2019.
 * <p>
 * Copyright by Niklas Emmrich.
 */
public class SnakeLauncher {

    public static void main(String[] args) {
        System.out.println("Initializing Snake...");

        Snake snake = new Snake();
        snake.loadSnakeMenu(new StartMenu());


        System.out.println("Snake ended.");
    }
}
