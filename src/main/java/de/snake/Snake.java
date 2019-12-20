package de.snake;

import de.snake.listener.SnakeKeyListener;
import de.snake.listener.SnakeMouseListener;
import de.snake.menu.IngameMenu;
import de.snake.menu.SnakeMenu;
import de.snake.menu.StartMenu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Niklas Emmrich on 29.10.2019.
 * <p>
 * Copyright by Niklas Emmrich.
 */
public class Snake {

    private static Snake instance;

    private final ArrayList<Game> games = new ArrayList<>();
    private Player playerOne, playerTwo, playerThree, playerFour;
    private Game currentGame;
    private SnakeMenu currentMenu;

    private JFrame windowFrame;

    public Snake() {
        instance = this;

        setPlayers();

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

    public boolean startGame(Game game) {
        if(this.currentGame != null)
            return false;

        this.games.add(game);


        this.currentGame = game;

        this.loadSnakeMenu(new IngameMenu());
        game.start();
        return true;
    }

    public void endGame() {
        if(this.currentGame == null)
            return;

        this.currentGame = null;
        this.loadSnakeMenu(new StartMenu());

        setPlayers();
    }

    public void setPlayers() {
        this.playerOne = new Player(0, "Spieler 1", 100, 100, Direction.EAST);
        this.playerTwo = new Player(1, "Spieler 2", 300, 10, Direction.EAST);
        this.playerThree = new Player(2, "Spieler 3", 20, 300, Direction.SOUTH);
        this.playerFour = new Player(3, "Spieler 4", 10, 10, Direction.EAST);

        this.playerOne.setLineColor(new Color(255, 50, 44));
        this.playerTwo.setLineColor(new Color(50, 255, 44));
        this.playerThree.setLineColor(new Color(251, 255, 61));
        this.playerFour.setLineColor(new Color(44, 50, 255));

        try {
            this.playerOne.setSnakeHead(ImageIO.read(getClass().getResource("/material/snake/snakegifROT.gif")));
            this.playerTwo.setSnakeHead(ImageIO.read(getClass().getResource("/material/snake/snakegifgreen.gif")));
            this.playerThree.setSnakeHead(ImageIO.read(getClass().getResource("/material/snake/snakegifgelb.gif")));
            this.playerFour.setSnakeHead(ImageIO.read(getClass().getResource("/material/snake/snakegifblau.gif")));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
