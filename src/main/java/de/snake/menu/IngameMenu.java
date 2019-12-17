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


        g.drawString("Spielzeit: "+game.getPlayTime(), WINDOW_WIDTH - 300, 15);
        g.drawString("TPS: "+game.getTicksPerSecond(), WINDOW_WIDTH - 200, 15);


        game.getPlayers().forEach(player -> {
            g.setColor(player.getLineColor());
            player.getLinePoints().forEach((point, thickness) -> {

                g.fillOval(Integer.parseInt(point.split(";")[0]), Integer.parseInt(point.split(";")[1]),
                        thickness, thickness);
            });

            g.setColor(Color.GREEN);
            if(player.getSnakeHead() == null)
                g.fillOval(player.getX(), player.getY(),
                        player.getLineThickness(), player.getLineThickness());
            else {
                g.drawImage(player.getSnakeHead(), player.getX()-player.getLineThickness()/2,
                        player.getY()-player.getLineThickness()/2,
                        player.getLineThickness()*2, player.getLineThickness()*2, this);
            }
        });

        final int[] currentMessageLine = {1};
        g.setColor(Color.RED);
        game.getDeadPlayers().forEach(player -> {
            currentMessageLine[0]++;

            g.drawString(player.getDisplayName()+" is dead.", WINDOW_WIDTH - 300, 20*currentMessageLine[0]);
        });

        if(game.getWinner() != null) {
            currentMessageLine[0]++;
            g.setColor(new Color(54, 184, 0));
            g.drawString(game.getWinner().getDisplayName()+" has won.", WINDOW_WIDTH - 300, 20*currentMessageLine[0]);
        }
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

            case StaticConstants.PLAYER_TWO_KEY_LEFT:
                playerTwo.move(playerTwo.getDirection().getLeftDirection());
                break;
            case StaticConstants.PLAYER_TWO_KEY_RIGHT:
                playerTwo.move(playerTwo.getDirection().getRightDirection());
                break;

            case StaticConstants.PLAYER_THREE_KEY_LEFT:
                playerThree.move(playerThree.getDirection().getLeftDirection());
                break;
            case StaticConstants.PLAYER_THREE_KEY_RIGHT:
                playerThree.move(playerThree.getDirection().getRightDirection());
                break;

            case StaticConstants.PLAYER_FOUR_KEY_LEFT:
                playerFour.move(playerFour.getDirection().getLeftDirection());
                break;
            case StaticConstants.PLAYER_FOUR_KEY_RIGHT:
                playerFour.move(playerFour.getDirection().getRightDirection());
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
