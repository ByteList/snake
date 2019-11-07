package de.snake.menu;

import de.snake.Game;
import de.snake.Snake;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Niklas Emmrich on 29.10.2019.
 * <p>
 * Copyright by Niklas Emmrich.
 */
public class IngameMenu extends SnakeMenu {

    private final Snake snake = Snake.getInstance();
    private final Game game = snake.getCurrentGame();

    public IngameMenu() {
        super("Snake - Im Spiel");
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("Spielzeit: "+game.getPlayTime(), 50, 50);
        g.drawString("TPS: "+game.getTicksPerSecond(), 200, 50);
    }
}
