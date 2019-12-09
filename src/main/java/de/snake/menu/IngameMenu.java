package de.snake.menu;

import de.snake.Direction;
import de.snake.Game;
import de.snake.Snake;
import de.snake.StaticConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

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

        game.getPlayers().forEach(player -> {
            g.drawOval((int)player.getX(), (int)player.getY(), 5, 5);
        });

    }

    @Override
    public void onKeyPressed(KeyEvent e) {
        Direction direction = null;

        System.out.println(e.getKeyCode());

        switch (e.getKeyCode()) {
            case StaticConstants.PLAYER_ONE_KEY_LEFT:
                if(snake.getPlayerOne().isDirectionLocked())
                    break;

                switch (snake.getPlayerOne().getDirection()) {
                    case NORTH:
                        direction = Direction.WEST;
                        break;
                    case EAST:
                        direction = Direction.NORTH;
                        break;
                    case SOUTH:
                        direction = Direction.EAST;
                        break;
                    case WEST:
                        direction = Direction.SOUTH;
                }

                snake.getPlayerOne().move(direction);
                break;
            case StaticConstants.PLAYER_ONE_KEY_RIGHT:
                if(snake.getPlayerOne().isDirectionLocked())
                    break;

                switch (snake.getPlayerOne().getDirection()) {
                    case NORTH:
                        direction = Direction.EAST;
                        break;
                    case EAST:
                        direction = Direction.SOUTH;
                        break;
                    case SOUTH:
                        direction = Direction.WEST;
                        break;
                    case WEST:
                        direction = Direction.NORTH;
                }

                snake.getPlayerOne().move(direction);
                break;
        }
    }

    @Override
    public void onKeyReleased(KeyEvent e) {
        System.out.println("RE: "+e.getKeyCode());
        switch (e.getKeyCode()) {
            case StaticConstants.PLAYER_ONE_KEY_LEFT:
            case StaticConstants.PLAYER_ONE_KEY_RIGHT:
                snake.getPlayerOne().setDirectionLocked(false);
                break;
        }
    }

    @Override
    public void onMouseClicked(MouseEvent e) {

    }
}
