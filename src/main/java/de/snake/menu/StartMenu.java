package de.snake.menu;

import de.snake.Game;
import de.snake.Snake;
import de.snake.SnakeMap;
import de.snake.StaticConstants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

import static de.snake.StaticConstants.*;

/**
 * Created by Niklas Emmrich on 29.10.2019.
 * <p>
 * Copyright by Niklas Emmrich.
 */
public class StartMenu extends SnakeMenu {

    private final Snake snake = Snake.getInstance();

    private int init = 0;

    private ImageIcon enabledImage, disabledImage;

    private final JButton buttonPlayerOne;
    private final JButton buttonPlayerTwo;
    private final JButton buttonPlayerThree;
    private final JButton buttonPlayerFour;
//    private final JButton buttonSwitch;
    private final JButton buttonMapSmall;
    private final JButton buttonMapMedium;
    private final JButton buttonMapLarge;
    private final JButton buttonStartGame;

    public StartMenu() {
        super("Snake - Hauptmenü");

        try {
            this.enabledImage = new ImageIcon(ImageIO.read(getClass().getResource("/material/element/b_Yes.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.disabledImage = new ImageIcon(ImageIO.read(getClass().getResource("/material/element/b_No.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.buttonPlayerOne = new JButton();
        this.buttonPlayerTwo = new JButton();
        this.buttonPlayerThree = new JButton();
        this.buttonPlayerFour = new JButton();
//        this.buttonSwitch = new JButton();
        this.buttonMapSmall = new JButton();
        this.buttonMapMedium = new JButton();
        this.buttonMapLarge = new JButton();
        this.buttonStartGame = new JButton();


        setButton(buttonPlayerOne, "playerOne");
        setButton(buttonPlayerTwo, "playerTwo");
        setButton(buttonPlayerThree, "playerThree");
        setButton(buttonPlayerFour, "playerFour");
        setButton(buttonMapSmall, "mapSmall");
        setButton(buttonMapMedium, "mapMedium");
        setButton(buttonMapLarge, "mapLarge");
        setButton(buttonStartGame, "startGame", false);

        buttonStartGame.setActionCommand("click:startGame");

        this.add(buttonPlayerOne);
        this.add(buttonPlayerTwo);
        this.add(buttonPlayerThree);
        this.add(buttonPlayerFour);
        this.add(buttonMapSmall);
        this.add(buttonMapMedium);
        this.add(buttonMapLarge);

        setButtonEnabled(buttonMapMedium, true);

//        try {
//            Image img = ImageIO.read(getClass().getResource("/material/items/test.gif"));
//
//            buttonSwitch.setIcon(new ImageIcon(img));
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        buttonSwitch.setContentAreaFilled(false);
//        buttonSwitch.setBorderPainted(false);
//        this.add(buttonSwitch);

        try {
            Image img = ImageIO.read(getClass().getResource("/material/element/b_Play2.png"));

            buttonStartGame.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        buttonStartGame.setContentAreaFilled(false);
        buttonStartGame.setBorderPainted(false);
        this.add(buttonStartGame);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
        init = 1;
    }

    private void doDrawing(Graphics g) {

        g.fillRect(0, WINDOW_HEIGHT / 2,WINDOW_WIDTH - 350,1);
        g.fillRect(WINDOW_WIDTH - 350, 0,1,WINDOW_HEIGHT);


        buttonPlayerOne.setBounds(50,50,50,50);
        buttonPlayerTwo.setBounds(50,110,50,50);
        buttonPlayerThree.setBounds(50,170,50,50);
        buttonPlayerFour.setBounds(50,230,50,50);


//        buttonSwitch.setBounds(50,500,250,80);

        buttonMapSmall.setBounds(50,650,45,45);
        buttonMapMedium.setBounds(250,650,45,45);
        buttonMapLarge.setBounds(450,650,45,45);

        buttonStartGame.setBounds(450,150,80,80);


        g.drawString("Player1 A & D",120,75 );
        g.drawString("Player2 < & >",120,135 );
        g.drawString("Player3 I & P",120,195 );
        g.drawString("Player4 B & M",120,255 );
        //g.drawString("Items",120,525 );
        g.drawString("Map Small",130,675 );
        g.drawString("Map Medium",330,675 );
        g.drawString("Map Large",530,675 );


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


    private void setButton(JButton button, String name){
        setButton(button, name, true);
    }
    private void setButton(JButton button, String name, boolean iconButton) {
        button.setName(name);

        if(iconButton)
            setButtonEnabled(button, false);

        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.addActionListener(e -> {
            switch (e.getActionCommand()) {
                case "click:enable":
                    setButtonEnabled(button, true);
                    break;
                case "click:disable":
                    if(button.getName().startsWith("map"))
                        return;

                    setButtonEnabled(button, false);
                    break;
                case "click:startGame":
                    startGame();
                    break;
            }
        });
    }

    private void setButtonEnabled(JButton button, boolean enabled) {
        if(enabled && enabledImage != null) {
            button.setIcon(enabledImage);
            button.setActionCommand("click:disable");

            if(button.getName().equals("mapSmall")) {
                setButtonEnabled(buttonMapMedium, false);
                setButtonEnabled(buttonMapLarge, false);
            }
            if(button.getName().equals("mapMedium")) {
                setButtonEnabled(buttonMapSmall, false);
                setButtonEnabled(buttonMapLarge, false);
            }
            if(button.getName().equals("mapLarge")) {
                setButtonEnabled(buttonMapMedium, false);
                setButtonEnabled(buttonMapSmall, false);
            }
            return;
        }
        if(!enabled && disabledImage != null) {
            button.setIcon(disabledImage);
            button.setActionCommand("click:enable");
        }
    }


    private void startGame() {
        SnakeMap snakeMap = null;
        Game game = null;
        if(buttonMapSmall.getActionCommand().equals("click:disable")) {
            snakeMap = MAPS.get("small");
        } else if(buttonMapMedium.getActionCommand().equals("click:disable")) {
            snakeMap = MAPS.get("medium");
        } else if(buttonMapLarge.getActionCommand().equals("click:disable")) {
            snakeMap = MAPS.get("large");
        }

        game = new Game(snake.getGames().size(), snakeMap);

        if(buttonPlayerOne.getActionCommand().equals("click:disable")) {
            game.registerPlayer(snake.getPlayerOne());
        }
        if(buttonPlayerTwo.getActionCommand().equals("click:disable")) {
            game.registerPlayer(snake.getPlayerTwo());
        }
        if(buttonPlayerThree.getActionCommand().equals("click:disable")) {
            game.registerPlayer(snake.getPlayerThree());
        }
        if(buttonPlayerFour.getActionCommand().equals("click:disable")) {
            game.registerPlayer(snake.getPlayerFour());
        }

        if(game.getPlayers().size() < 2) {
            JOptionPane.showMessageDialog(this, "Es müssen mindestens 2 Spieler ausgewählt sein!");
            return;
        }

        snake.startGame(game);
    }
}
