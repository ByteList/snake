package de.snake.menu;

import de.snake.Snake;

import javax.swing.*;

/**
 * Created by Niklas Emmrich on 04.11.2019.
 * <p>
 * Copyright by Niklas Emmrich.
 */
public abstract class SnakeMenu extends JPanel {

    private final Snake snake = Snake.getInstance();

    public SnakeMenu(String name) {
        this.setSize(snake.getWindowFrame().getWidth(), snake.getWindowFrame().getHeight());
        this.setName(name);
    }
}
