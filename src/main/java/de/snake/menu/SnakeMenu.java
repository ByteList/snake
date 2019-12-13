package de.snake.menu;

import de.snake.Snake;
import de.snake.StaticConstants;
import de.snake.listener.SnakeKeyListener;
import de.snake.listener.SnakeMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Niklas Emmrich on 04.11.2019.
 * <p>
 * Copyright by Niklas Emmrich.
 */
public abstract class SnakeMenu extends JPanel {

    public SnakeMenu(String name) {
        this.setPreferredSize(new Dimension(StaticConstants.WINDOW_WIDTH, StaticConstants.WINDOW_HEIGHT));
        this.setName(name);
    }

    public abstract void onKeyPressed(KeyEvent e);

    public abstract void onKeyReleased(KeyEvent e);

    public abstract void onMouseClicked(MouseEvent e);
}
