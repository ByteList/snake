package de.snake;

import de.snake.menu.SnakeMenu;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Niklas Emmrich on 29.10.2019.
 * <p>
 * Copyright by Niklas Emmrich.
 */
public class Snake {

    private static Snake instance;

    private final ArrayList<Game> games = new ArrayList<>();
    private Game currentGame;
    private SnakeMenu currentMenu;

    private JFrame windowFrame;

    public Snake() {
        instance = this;

        this.windowFrame = new JFrame("Snake");
        this.windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.windowFrame.setBounds(50, 50, 900, 600);
    }

    public void loadSnakeMenu(SnakeMenu snakeMenu) {
        if(currentMenu != null && currentMenu.getName().equals(snakeMenu.getName())) {
            return;
        }
        if(currentMenu != null) {
            this.windowFrame.remove(currentMenu);

        }

        this.windowFrame.setFocusable(true);
        this.windowFrame.setResizable(false);

        this.windowFrame.setTitle(snakeMenu.getName());
        this.windowFrame.setVisible(true);
        this.windowFrame.add(snakeMenu);

        currentMenu = snakeMenu;
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
