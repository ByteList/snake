package de.snake.listener;

import de.snake.Snake;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Niklas Emmrich on 29.10.2019.
 * <p>
 * Copyright by Niklas Emmrich.
 */
public class SnakeMouseListener implements MouseListener {

    public void mouseClicked(MouseEvent e) {
        Snake.getInstance().getCurrentMenu().onMouseClicked(e);
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
