package de.snake;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import static de.snake.StaticConstants.*;

public class Game {

    private Snake snake = Snake.getInstance();

    private final int id;
    private final ArrayList<Player> players = new ArrayList<>();
    private Player winner;
    private Timer gameTimer, counterTimer;
    private int playTime = 0, ticksPerSecond = 0, deadPlayers;
    private final SnakeMap snakeMap;

    public Game(int id, SnakeMap snakeMap) {
        this.id = id;
        this.snakeMap = snakeMap;

        this.gameTimer = new Timer();
        this.counterTimer = new Timer();
    }

    public void start() {
        this.gameTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                ticksPerSecond++;

                if(deadPlayers > players.size()-1) {
                    gameTimer.cancel();
                    counterTimer.cancel();
                }

                players.forEach(player -> {
                    if(player.isAlive()) {
                        player.setXY(player.getX() + player.getDirection().getXVal()*player.getSpeed(),
                                player.getY() + player.getDirection().getYVal()*player.getSpeed());

                        return;
                    }
                    deadPlayers++;
                });

                snake.getCurrentMenu().repaint();
            }
        }, 0, 1000/StaticConstants.GAME_TPS);

        this.counterTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                ticksPerSecond = 0;
                playTime++;
            }
        }, 0, 1000);
    }

    public void registerPlayer(Player player) {
        if(this.players.contains(player))
            return;

        this.players.add(player);
    }

    public int getId() {
        return id;
    }

    public Collection<Player> getPlayers() {
        return Collections.unmodifiableCollection(this.players);
    }

    public SnakeMap getSnakeMap() { return this.snakeMap; }

    public Player getWinner() {
        return winner;
    }

    public Timer getGameTimer() {
        return gameTimer;
    }

    public Timer getCounterTimer() {
        return counterTimer;
    }

    public int getPlayTime() {
        return playTime;
    }

    public int getTicksPerSecond() {
        return ticksPerSecond;
    }

}
