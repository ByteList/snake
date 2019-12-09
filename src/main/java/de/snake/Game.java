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
    private final ArrayList<SnakeMap> maps = new ArrayList<>();
    private Player winner;
    private Timer gameTimer, counterTimer;
    private int playTime = 0, ticksPerSecond = 0;

    public Game(int id) {
        this.id = id;

        this.gameTimer = new Timer();
        this.gameTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                ticksPerSecond++;

                players.forEach(player -> {
                    player.setXY(player.getX() + player.getDirection().getXVal()*player.getSpeed(),
                            player.getY() + player.getDirection().getYVal()*player.getSpeed());
                });

                snake.getCurrentMenu().repaint();
            }
        }, 0, 100);

        this.counterTimer = new Timer();
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

    public Collection<SnakeMap> getMaps() {
        return Collections.unmodifiableCollection(this.maps);
    }

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
