package de.snake;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class SnakeMap {

    private int width, height;
    private String backgroundPath;

    private Image backgroundImage;

    public SnakeMap(int width, int height, String backgroundPath) {
        this.width = width;
        this.height = height;
        this.backgroundPath = backgroundPath;

        try {
            Image image  = ImageIO.read(getClass().getResource(backgroundPath));
            this.backgroundImage = image.getScaledInstance(width, height, 10);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getBackgroundPath() {
        return backgroundPath;
    }

    public Image getBackgroundImage() {
        return backgroundImage;
    }
}
