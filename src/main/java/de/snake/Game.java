package de.snake;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Game {

    private Snake snake = Snake.getInstance();

    private final int id;
    private final ArrayList<Player> players = new ArrayList<>();
    private final ArrayList<SnakeMap> maps = new ArrayList<>();
    private Player winner;
    private ScheduledFuture gameTimer, counterTimer;
    private int playTime = 0;

    public Game(int id) {
        this.id = id;

        this.gameTimer = Executors.newSingleThreadScheduledExecutor().schedule(()-> {

            snake.getCurrentMenu().repaint();
        }, 100, TimeUnit.MILLISECONDS);

        this.counterTimer = Executors.newSingleThreadScheduledExecutor().schedule(()-> {
            playTime++;
        }, 1, TimeUnit.SECONDS);
    }

    public int getId() {
        return id;
    }

    public Collection<Player> getPlayers() {
        return Collections.unmodifiableCollection(this.players);
    }

    public Collection<SnakeMap> getMaps() {
        return Collections.unmodifiableCollection(this.maps);
    }

    public Player getWinner() {
        return winner;
    }

    public ScheduledFuture getGameTimer() {
        return gameTimer;
    }

    public ScheduledFuture getCounterTimer() {
        return counterTimer;
    }

    public int getPlayTime() {
        return playTime;
    }
}
