package de.snake;

import de.snake.listener.SnakeKeyListener;
import de.snake.listener.SnakeMouseListener;
import de.snake.menu.IngameMenu;
import de.snake.menu.SnakeMenu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static de.snake.StaticConstants.PLAYER_ONE_KEY_LEFT;
import static de.snake.StaticConstants.PLAYER_ONE_KEY_RIGHT;

/**
 * Created by Niklas Emmrich on 29.10.2019.
 * <p>
 * Copyright by Niklas Emmrich.
 */
public class Snake {

    private static Snake instance;

    private final ArrayList<Game> games = new ArrayList<>();
    private final Player playerOne, playerTwo, playerThree, playerFour;
    private Game currentGame;
    private SnakeMenu currentMenu;

    private JFrame windowFrame;

    public Snake() {
        instance = this;

        this.playerOne = new Player(0, "Spieler 1", 100, 100, Direction.EAST);
        this.playerTwo = new Player(1, "Spieler 2", 300, 10, Direction.EAST);
        this.playerThree = new Player(2, "Spieler 3", 20, 300, Direction.SOUTH);
        this.playerFour = new Player(3, "Spieler 4", 10, 10, Direction.EAST);

        this.windowFrame = new JFrame("Snake");
        this.windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.windowFrame.addKeyListener(new SnakeKeyListener());
        this.windowFrame.addMouseListener(new SnakeMouseListener());
    }

    public void loadSnakeMenu(SnakeMenu snakeMenu) {
        if(currentMenu != null && currentMenu.getName().equals(snakeMenu.getName())) {
            return;
        }
        if(currentMenu != null) {
            this.windowFrame.remove(currentMenu);
            this.windowFrame.setVisible(false);

        }

        this.windowFrame.add(snakeMenu);
        this.windowFrame.setTitle(snakeMenu.getName());
        this.windowFrame.setResizable(false);
        this.windowFrame.pack();

        this.windowFrame.setLocationRelativeTo(null);
        this.windowFrame.setVisible(true);


        currentMenu = snakeMenu;
    }

    public void debug() {
        this.currentGame.registerPlayer(this.playerOne);
        this.currentGame.registerPlayer(this.playerTwo);
    }

    public boolean startGame(SnakeMap snakeMap) {
        if(this.currentGame != null)
            return false;

        Game game = new Game(games.size(), snakeMap);
        this.games.add(game);

        this.currentGame = game;

        game.getPlayers().forEach(player -> game.addLinePoint(player.getX()+";"+player.getY(),
                player.getLineThickness()));

        this.loadSnakeMenu(new IngameMenu());
        game.start();
        return true;
    }


    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Player getPlayerThree() {
        return playerThree;
    }

    public Player getPlayerFour() {
        return playerFour;
    }

    public static Snake getInstance() {
        return instance;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public SnakeMenu getCurrentMenu() {
        return currentMenu;
    }

    public JFrame getWindowFrame() {
        return windowFrame;
    }
}
