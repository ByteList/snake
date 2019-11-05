package de.snake;

public class SnakeMap {

    private int x, y;
    private String backgroundPath;

    public SnakeMap(int x, int y, String backgroundPath) {
        this.x = x;
        this.y = y;
        this.backgroundPath = backgroundPath;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getBackgroundPath() {
        return backgroundPath;
    }
}
