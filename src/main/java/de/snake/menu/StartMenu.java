package de.snake.menu;

import de.snake.StaticConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static de.snake.StaticConstants.*;

/**
 * Created by Niklas Emmrich on 29.10.2019.
 * <p>
 * Copyright by Niklas Emmrich.
 */
public class StartMenu extends SnakeMenu {

    public StartMenu() {
        super("Snake - Hauptmenü");
    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(0, WINDOW_HEIGHT / 2,WINDOW_WIDTH - 350,1);
        g.fillRect(WINDOW_WIDTH - 350, 0,1,WINDOW_HEIGHT);

        JButton buttonA = new JButton("Button1");
        this.add(buttonA);
        buttonA.setBounds(50,50,50,50);

        JButton buttonB = new JButton("Button2");
        this.add(buttonB);
        buttonB.setBounds(50,110,50,50);

        JButton buttonC = new JButton("Button3");
        this.add(buttonC);
        buttonC.setBounds(50,170,50,50);

        JButton buttonD = new JButton("Button4");
        this.add(buttonD);
        buttonD.setBounds(50,230,50,50);

        g.drawString("Player1",120,75 );
        g.drawString("Player2",120,135 );
        g.drawString("Player3",120,195 );
        g.drawString("Player4",120,255 );


    }

    @Override
    public void onKeyPressed(KeyEvent e) {

    }

    @Override
    public void onMouseClicked(MouseEvent e) {

    }
}
