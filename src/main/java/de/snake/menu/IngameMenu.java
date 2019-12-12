package de.snake.menu;

import de.snake.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static de.snake.StaticConstants.WINDOW_HEIGHT;
import static de.snake.StaticConstants.WINDOW_WIDTH;

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
        g.fillRect(WINDOW_WIDTH - 350, 0, 1, WINDOW_HEIGHT);

        g.drawImage(game.getSnakeMap().getBackgroundImage(), 0, 0, this);

        g.fillRect(0, game.getSnakeMap().getHeight(), game.getSnakeMap().getWidth(), 1);
        g.fillRect(game.getSnakeMap().getWidth(), 0, 1, game.getSnakeMap().getHeight());


        g.drawString("Spielzeit: "+game.getPlayTime(), 50, 50);
        g.drawString("TPS: "+game.getTicksPerSecond(), 200, 50);


        game.getPlayers().forEach(player -> {
            g.setColor(Color.RED);
            player.getLinePoints().forEach((point, thickness) -> {

                g.fillOval(Integer.parseInt(point.split(";")[0]), Integer.parseInt(point.split(";")[1]),
                        thickness, thickness);
            });

            g.setColor(Color.GREEN);
            g.fillOval(player.getX(), player.getY(), player.getLineThickness(), player.getLineThickness());
        });
    }

    @Override
    public void onKeyPressed(KeyEvent e) {
        Direction direction = null;
        Player playerOne = snake.getPlayerOne(),
        playerTwo = snake.getPlayerTwo(),
        playerThree = snake.getPlayerThree(),
        playerFour = snake.getPlayerFour();

        System.out.println(e.getKeyCode());

        switch (e.getKeyCode()) {
            case StaticConstants.PLAYER_ONE_KEY_LEFT:
                playerOne.move(playerOne.getDirection().getLeftDirection());
                break;
            case StaticConstants.PLAYER_ONE_KEY_RIGHT:
                playerOne.move(playerOne.getDirection().getRightDirection());
                break;
        }
    }

    @Override
    public void onKeyReleased(KeyEvent e) {

    }

    @Override
    public void onMouseClicked(MouseEvent e) {

    }
}
