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
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

        g.fillRect(0, WINDOW_HEIGHT / 2,WINDOW_WIDTH - 350,1);
        g.fillRect(WINDOW_WIDTH - 350, 0,1,WINDOW_HEIGHT);

        JButton buttonA = new JButton("Button1");
        buttonA.setBounds(50,50,50,50);
        add(buttonA);

        JButton buttonB = new JButton("Button2");
        this.add(buttonB);
        buttonB.setBounds(50,110,50,50);

        JButton buttonC = new JButton("Button3");
        this.add(buttonC);
        buttonC.setBounds(50,170,50,50);

        JButton buttonD = new JButton("Button4");
        this.add(buttonD);
        buttonD.setBounds(50,230,50,50);

        JButton buttonSwitch = new JButton("ButtonSwitch 1");
        this.add(buttonSwitch);
        buttonSwitch.setBounds(50,500,100,40);

        JButton buttonMapSmall = new JButton("ButtonSwitch 2");
        this.add(buttonMapSmall);
        buttonMapSmall.setBounds(50,650,30,30);

        JButton buttonMapMedium = new JButton("ButtonSwitch 3");
        this.add(buttonMapMedium);
        buttonMapMedium.setBounds(250,650,30,30);

        JButton buttonMapLarge = new JButton("ButtonSwitch 4");
        this.add(buttonMapLarge);
        buttonMapLarge.setBounds(450,650,30,30);

        g.drawString("Player1 A & D",120,75 );
        g.drawString("Player2 < & >",120,135 );
        g.drawString("Player3 I & P",120,195 );
        g.drawString("Player4 B & M",120,255 );
        g.drawString("Items",120,525 );
        g.drawString("Map Small",90,667 );
        g.drawString("Map Medium",290,667 );
        g.drawString("Map Large",490,667 );


        Toolkit.getDefaultToolkit().sync();

    }

    @Override
    public void onKeyPressed(KeyEvent e) {

    }

    @Override
    public void onKeyReleased(KeyEvent e) {

    }

    @Override
    public void onMouseClicked(MouseEvent e) {

    }
}
