package de.snake.bootstrap;

import de.snake.Snake;
import de.snake.StaticConstants;
import de.snake.menu.StartMenu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Niklas Emmrich on 29.10.2019.
 * <p>
 * Copyright by Niklas Emmrich.
 */
public class SnakeLauncher {

    public static void main(String[] args) {
        System.out.println("Initializing Snake...");

        EventQueue.invokeLater(()-> {
            Snake snake = new Snake();
            snake.loadSnakeMenu(new StartMenu());

            // ============== DEBUG ==============
        snake.startGame(StaticConstants.MAPS.get("small"));
        snake.debug();
        });
    }
}
