package de.snake.menu;

import de.snake.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

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
    private Image backgroundImage;

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
        try {
            this.backgroundImage = ImageIO.read(getClass().getResource("/material/background/menu.jpg"));
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
        setButton(buttonMapSmall, "mapSmall", false);
        setButton(buttonMapMedium, "mapMedium", false);
        setButton(buttonMapLarge, "mapLarge", false);
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
        if(snake.getGames().size() > 0) {
            switch (snake.getGames().get(snake.getGames().size()-1).getSnakeMap().getName()) {
                case "small":
                    setButtonEnabled(this.buttonMapSmall, true);
                    break;
                case "medium":
                    setButtonEnabled(this.buttonMapMedium, true);
                    break;
                case "large":
                    setButtonEnabled(this.buttonMapLarge, true);
                    break;
            }
        }



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
        g.drawImage(this.backgroundImage, 0, 0, this);
        g.setFont(new Font("Serif", Font.BOLD, 20));

        g.fillRect(0, WINDOW_HEIGHT / 2,WINDOW_WIDTH - 350,1);
        g.fillRect(WINDOW_WIDTH - 350, 0,1,WINDOW_HEIGHT);

        buttonPlayerOne.setBounds(50,50,50,50);
        buttonPlayerTwo.setBounds(50,110,50,50);
        buttonPlayerThree.setBounds(50,170,50,50);
        buttonPlayerFour.setBounds(50,230,50,50);

        buttonStartGame.setBounds(450,215,80,80);

        buttonMapSmall.setBounds(50,450,45,45);
        buttonMapMedium.setBounds(250,450,45,45);
        buttonMapLarge.setBounds(470,450,45,45);


        g.setColor(snake.getPlayerOne().getLineColor());
        g.drawString(snake.getPlayerOne().getDisplayName(),120,80 );
        g.drawString("A & D",280,80 );

        g.setColor(snake.getPlayerTwo().getLineColor());
        g.drawString(snake.getPlayerTwo().getDisplayName(),120,140 );
        g.drawString("< & >",280,140 );

        g.setColor(snake.getPlayerThree().getLineColor());
        g.drawString(snake.getPlayerThree().getDisplayName(),120,200 );
        g.drawString("I & P",280,200 );

        g.setColor(snake.getPlayerFour().getLineColor());
        g.drawString(snake.getPlayerFour().getDisplayName(),120,260 );
        g.drawString("B & M",280,260 );

        g.setColor(Color.ORANGE);

        g.drawString("Spielen", 520, 260);

        //g.drawString("Items",120,525 );
        g.drawString("kleine Karte",130,475 );
        g.drawString("normale Karte",330,475 );
        g.drawString("große Karte",530,475 );

        g.drawString("Letzte Runde: ", WINDOW_WIDTH - 300, 60);
        g.drawRect(WINDOW_WIDTH - 300,150,80,50);
        g.drawRect(WINDOW_WIDTH - 220,120,80,80);
        g.drawRect(WINDOW_WIDTH - 140,170,80,30);

        if(snake.getGames().size() > 0) {
            Game game = snake.getGames().get(snake.getGames().size() - 1);
            Player[] luckyLoosers = game.getDeadPlayers().toArray(new Player[0]);
            if (luckyLoosers.length == 3 || luckyLoosers.length == 2) {
                System.out.println("LOOSERS: " + luckyLoosers[luckyLoosers.length - 1].getDisplayName());
                System.out.println("LOOSERS: " + luckyLoosers[luckyLoosers.length - 2].getDisplayName());
                g.setColor(luckyLoosers[luckyLoosers.length - 1].getLineColor());
                g.drawString(luckyLoosers[luckyLoosers.length - 1].getDisplayName(),WINDOW_WIDTH - 300,140 );

                g.setColor(luckyLoosers[luckyLoosers.length - 2].getLineColor());
                g.drawString(luckyLoosers[luckyLoosers.length - 2].getDisplayName(),WINDOW_WIDTH - 130,160 );
            } else {
                System.out.println("JUSTONELOOSER: "+luckyLoosers[luckyLoosers.length - 1].getDisplayName());
                g.setColor(luckyLoosers[luckyLoosers.length - 1].getLineColor());
                g.drawString(luckyLoosers[luckyLoosers.length - 1].getDisplayName(),WINDOW_WIDTH - 300,140 );
            }

            System.out.println("WINNER: " + game.getWinner().getDisplayName());
            g.setColor(game.getWinner().getLineColor());
            g.drawString(game.getWinner().getDisplayName(),WINDOW_WIDTH - 220,110 );
        }

        g.setColor(Color.ORANGE);
        g.drawString("Gwinner der letzten Runden:", WINDOW_WIDTH - 300, 300);
        final int[] currentMessageLine = {16};
        snake.getGames().forEach(game -> {
            currentMessageLine[0]++;

            g.setColor(Color.ORANGE);
            g.drawString("Runde " + (game.getId() + 1) +": ", WINDOW_WIDTH - 300, 22*currentMessageLine[0]);
            g.setColor(game.getWinner().getLineColor());
            g.drawString(game.getWinner().getDisplayName(), WINDOW_WIDTH - 190, 22*currentMessageLine[0]);

        });


        if(snake.getPlayerOne().getSelected() == 1)
            setButtonEnabled(this.buttonPlayerOne, true);
        else setButtonEnabled(this.buttonPlayerOne, false);

        if(snake.getPlayerTwo().getSelected() == 1)
            setButtonEnabled(this.buttonPlayerTwo, true);
        else setButtonEnabled(this.buttonPlayerTwo, false);

        if(snake.getPlayerThree().getSelected() == 1)
            setButtonEnabled(this.buttonPlayerThree, true);
        else setButtonEnabled(this.buttonPlayerThree, false);

        if(snake.getPlayerFour().getSelected() == 1)
            setButtonEnabled(this.buttonPlayerFour, true);
        else setButtonEnabled(this.buttonPlayerFour, false);


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
        setButton(button, name, false);
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

    private void setButtonEnabled(JButton button, boolean enabled, JButton... negativeButtons) {
        if(enabled && enabledImage != null) {
            button.setIcon(enabledImage);
            button.setActionCommand("click:disable");

            for(JButton negativeButton : negativeButtons) {
                setButtonEnabled(negativeButton, false);
            }

            if(button.getName().equals("playerOne")) {
                snake.getPlayerOne().setSelected(1);
            }
            if(button.getName().equals("playerTwo")) {
                snake.getPlayerTwo().setSelected(1);
            }
            if(button.getName().equals("playerThree")) {
                snake.getPlayerThree().setSelected(1);
            }
            if(button.getName().equals("playerFour")) {
                snake.getPlayerFour().setSelected(1);
            }

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


            if(button.getName().equals("playerOne")) {
                snake.getPlayerOne().setSelected(0);
            }
            if(button.getName().equals("playerTwo")) {
                snake.getPlayerTwo().setSelected(0);
            }
            if(button.getName().equals("playerThree")) {
                snake.getPlayerThree().setSelected(0);
            }
            if(button.getName().equals("playerFour")) {
                snake.getPlayerFour().setSelected(0);
            }
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
