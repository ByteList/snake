package de.snake;

import java.util.ArrayList;
import java.util.Timer;

public class Game {

    private final int id;
    private final ArrayList<Player> players = new ArrayList<>();
    private Player winner;
    private Timer gameTimer, counterTimer;

    public Game(int id) {
        this.id = id;
    }
}
