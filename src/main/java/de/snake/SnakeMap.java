package de.snake;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class SnakeMap {

    private String name;

    private int width, height;

    private Image foregroundImage;

    public SnakeMap(String name, int width, int height, String foregroundPath) {
        this.name = name;
        this.width = width;
        this.height = height;

        try {
            Image image  = ImageIO.read(getClass().getResource(foregroundPath));
            this.foregroundImage = image.getScaledInstance(width, height, 10);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Image getForegroundImage() {
        return foregroundImage;
    }

}
