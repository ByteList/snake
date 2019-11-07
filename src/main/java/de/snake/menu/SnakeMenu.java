package de.snake.menu;

import de.snake.Snake;
import de.snake.listener.SnakeKeyListener;
import de.snake.listener.SnakeMouseListener;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

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
        this.addKeyListener(new SnakeKeyListener());
        this.addMouseListener(new SnakeMouseListener());
    }

    public abstract void onKeyPressed(KeyEvent e);

    public abstract void onMouseClicked(MouseEvent e);
}
