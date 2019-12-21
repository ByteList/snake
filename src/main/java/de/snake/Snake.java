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

        loadSnakeMenu(new StartMenu());
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

    public void startGame(Game game) {
        if(this.currentGame != null)
            return;

        if(this.games.size() > 15) {
            for(int i = 0; i < (this.games.size()-15); i++) {
                this.games.remove(1);
            }
        }

        this.games.add(game);


        this.currentGame = game;

        this.loadSnakeMenu(new IngameMenu());
        AtomicInteger count = new AtomicInteger();
        Player[] players = game.getPlayers().toArray(new Player[0]);
        game.getStartPoints().forEach((points, direction)-> {
            players[count.get()].setXY(points[0], points[1]);
            players[count.getAndIncrement()].setDirection(
                    direction[ThreadLocalRandom.current().nextInt(direction.length)]);
        });
        game.start();
    }

    public void endGame() {
        if(this.currentGame == null)
            return;

        this.currentGame = null;

        setPlayers();

        this.loadSnakeMenu(new StartMenu());
    }

    public void setPlayers() {
        int selectedOne = 0, selectedTwo = 0, selectedThree = 0, selectedFour = 0;

        if(this.playerOne != null)
            selectedOne = this.playerOne.getSelected();

        if(this.playerTwo != null)
            selectedTwo = this.playerTwo.getSelected();

        if(this.playerThree != null)
            selectedThree = this.playerThree.getSelected();

        if(this.playerFour != null)
            selectedFour = this.playerFour.getSelected();

        this.playerOne = new Player(0, "Spieler 1", selectedOne);
        this.playerTwo = new Player(1, "Spieler 2", selectedTwo);
        this.playerThree = new Player(2, "Spieler 3", selectedThree);
        this.playerFour = new Player(3, "Spieler 4", selectedFour);

        this.playerOne.setLineColor(new Color(255, 50, 44));
        this.playerTwo.setLineColor(new Color(50, 255, 44));
        this.playerThree.setLineColor(new Color(251, 255, 61));
        this.playerFour.setLineColor(new Color(44, 112, 255));

        try {
            this.playerOne.setSnakeHead(ImageIO.read(getClass().getResource("/material/snake/snakegifROT.gif")));
            this.playerTwo.setSnakeHead(ImageIO.read(getClass().getResource("/material/snake/snakegifgreen.gif")));
            this.playerThree.setSnakeHead(ImageIO.read(getClass().getResource("/material/snake/snakegifgelb.gif")));
            this.playerFour.setSnakeHead(ImageIO.read(getClass().getResource("/material/snake/snakegifblau.gif")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean exit() {
        if(JOptionPane.showConfirmDialog(null, "Möchtest du Snake wirklich beenden?", "Snake beenden?",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
            return true;
        }
        return false;
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
