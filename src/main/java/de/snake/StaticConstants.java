package de.snake;

import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * Created by Niklas Emmrich on 05.11.2019.
 * <p>r
 * Copyright by Niklas Emmrich.
 */
public class StaticConstants {

    public static final int GAME_TPS = 80;

    public static final int NORMAL_SPEED = 1;

    public static final int WINDOW_HEIGHT = 750;

    public static final int WINDOW_WIDTH =  1200;

    public static final int PLAYER_ONE_KEY_LEFT = KeyEvent.VK_A, PLAYER_ONE_KEY_RIGHT = KeyEvent.VK_D;

    public static final int PLAYER_TWO_KEY_LEFT = KeyEvent.VK_LEFT, PLAYER_TWO_KEY_RIGHT = KeyEvent.VK_RIGHT;

    public static final int PLAYER_THREE_KEY_LEFT = KeyEvent.VK_I, PLAYER_THREE_KEY_RIGHT = KeyEvent.VK_P;

    public static final int PLAYER_FOUR_KEY_LEFT = KeyEvent.VK_B, PLAYER_FOUR_KEY_RIGHT = KeyEvent.VK_M;

    public static final HashMap<String, SnakeMap> MAPS = new HashMap<String, SnakeMap>() {{
        put("small", new SnakeMap("small", WINDOW_WIDTH-350-200, WINDOW_HEIGHT-100, "/material/background/small.jpg"));
        put("medium", new SnakeMap("medium", WINDOW_WIDTH-350-100, WINDOW_HEIGHT-50, "/material/background/middle.jpg"));
        put("large", new SnakeMap("large", WINDOW_WIDTH-350, WINDOW_HEIGHT, "/material/background/big.jpg"));
    }};

}
