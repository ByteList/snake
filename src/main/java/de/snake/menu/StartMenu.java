package de.snake.menu;

import de.snake.StaticConstants;

import java.awt.*;

import static de.snake.StaticConstants.*;

/**
 * Created by Niklas Emmrich on 29.10.2019.
 * <p>
 * Copyright by Niklas Emmrich.
 */
public class StartMenu extends SnakeMenu {

    public StartMenu() {
        super("Snake - Hauptmenü");
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, WINDOW_HEIGHT / 2,WINDOW_WIDTH - 350,1);
    }
}
