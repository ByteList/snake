package de.snake;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static de.snake.StaticConstants.*;

public class Game {

    private Snake snake = Snake.getInstance();

    private final int id;
    private final ArrayList<Player> players = new ArrayList<>(), deadPlayers = new ArrayList<>();
    private final HashMap<String, Integer> linePoints = new HashMap<>();
    private Player winner;
    private Timer gameTimer, counterTimer;
    private int playTime = 0, ticksPerSecond = 0;
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

                if(deadPlayers.size() == players.size()-1) {
                    gameTimer.cancel();
                    counterTimer.cancel();
                    players.forEach(player -> {
                        if(player.isAlive())
                            winner = player;
                    });
                    ticksPerSecond = 0;
                }

                players.forEach(player -> {
                    if(player.isAlive()) {
                        player.setXY(player.getX() + player.getDirection().getXVal()*player.getSpeed(),
                                player.getY() + player.getDirection().getYVal()*player.getSpeed());

                        return;
                    }
                    if(!deadPlayers.contains(player))
                        deadPlayers.add(player);
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
    public HashMap<int[], Direction[]> getStartPoints(){
        HashMap<int[], Direction[]> startPoints = new HashMap<>();
        int anzahl = this.players.size();
        int width = this.snakeMap.getWidth();
        int height = this.snakeMap.getHeight();
        for(int i=0;i<anzahl;i++) {

            int[] points = new int[2];

                points[0] = ThreadLocalRandom.current().nextInt(100, (width-50));
                points[1] = ThreadLocalRandom.current().nextInt(100,(height-50));

            if(points[0]<100 && points[1]<100){
          startPoints.put(points, new Direction[]{Direction.EAST, Direction.SOUTH});
        }
            if(points[0]>800 && points[1]>800){
                startPoints.put(points, new Direction[]{Direction.WEST, Direction.NORTH});
            }
            if(points[0]<800 && points[1]<100){
                startPoints.put(points, new Direction[]{Direction.EAST, Direction.WEST, Direction.NORTH, Direction.SOUTH});
            }

        }

        return startPoints;
    }
    public int getId() {
        return id;
    }

    public Collection<Player> getPlayers() {
        return Collections.unmodifiableCollection(this.players);
    }

    public Collection<Player> getDeadPlayers() {
        return Collections.unmodifiableCollection(this.deadPlayers);
    }

    public HashMap<String, Integer> getLinePoints() {
        return new HashMap<>(this.linePoints);
    }

    public void addLinePoint(String linePoint, int thickness) {
        this.linePoints.put(linePoint, thickness);
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
