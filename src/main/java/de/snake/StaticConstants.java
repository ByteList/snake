package de.snake;

import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * Created by Niklas Emmrich on 05.11.2019.
 * <p>r
 * Copyright by Niklas Emmrich.
 */
public class StaticConstants {

    public static final int GAME_TPS = 20;

    public static final int NORMAL_SPEED = 3;

    public static final int POWER_SPEED = 5;

    public static final int WINDOW_HEIGHT = 750;

    public static final int WINDOW_WIDTH =  1200;

    public static final int PLAYER_ONE_KEY_LEFT = KeyEvent.VK_A, PLAYER_ONE_KEY_RIGHT = KeyEvent.VK_D;

    public static final int PLAYER_TWO_KEY_LEFT = KeyEvent.VK_A, PLAYER_TWO_KEY_RIGHT = KeyEvent.VK_D;

    public static final int PLAYER_THREE_KEY_LEFT = KeyEvent.VK_A, PLAYER_THREE_KEY_RIGHT = KeyEvent.VK_D;

    public static final int PLAYER_FOUR_KEY_LEFT = KeyEvent.VK_A, PLAYER_FOUR_KEY_RIGHT = KeyEvent.VK_D;

    public static final HashMap<String, SnakeMap> MAPS = new HashMap<String, SnakeMap>() {{
        put("small", new SnakeMap(WINDOW_WIDTH-350-200, WINDOW_HEIGHT-100, "/material/background/small.png"));
        put("middle", new SnakeMap(WINDOW_WIDTH-350-100, WINDOW_HEIGHT-50, "/material/background/middle.png"));
        put("big", new SnakeMap(WINDOW_WIDTH-350, WINDOW_HEIGHT, "/material/background/big.png"));
    }};

    public static final HashMap<int[], Direction[]> SPAWN_POINTS = new HashMap<int[], Direction[]>() {{
        put(new int[]{ 100, 100 }, new Direction[]{ Direction.SOUTH, Direction.EAST });
        put(new int[]{ 300, 50 }, new Direction[]{ Direction.SOUTH, Direction.EAST });

        put(new int[]{ 250, 250 }, new Direction[]{ Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST });

        put(new int[]{ 400, 200 }, new Direction[]{ Direction.NORTH, Direction.WEST });
    }};

}
