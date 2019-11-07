package de.snake.listener;

import de.snake.Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Niklas Emmrich on 29.10.2019.
 * <p>
 * Copyright by Niklas Emmrich.
 */
public class SnakeKeyListener implements KeyListener {

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        Snake.getInstance().getCurrentMenu().onKeyPressed(e);
    }

    public void keyReleased(KeyEvent e) {

    }
}
