package de.snake.menu;

import de.snake.StaticConstants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private final JButton buttonA;
    private final JButton buttonB;
    private final JButton buttonC;
    private final JButton buttonD;
    private final JButton buttonSwitch;
    private final JButton buttonMapSmall;
    private final JButton buttonMapMedium;
    private final JButton buttonMapLarge;

    public StartMenu() {
        super("Snake - Hauptmenü");
        buttonA = new JButton();
        buttonB = new JButton();
        buttonC = new JButton();
        buttonD = new JButton();
        buttonSwitch = new JButton();
        buttonMapSmall = new JButton();
        buttonMapMedium = new JButton();
        buttonMapLarge = new JButton();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
//        try {
//            Image img = ImageIO.read(StartMenu.class.getResourceAsStream("/b_No.PNG"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private void doDrawing(Graphics g) {

        g.fillRect(0, WINDOW_HEIGHT / 2,WINDOW_WIDTH - 350,1);
        g.fillRect(WINDOW_WIDTH - 350, 0,1,WINDOW_HEIGHT);

        try {
            Image img = ImageIO.read(getClass().getResource("/material/element/b_No.png"));

            buttonA.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        buttonA.setContentAreaFilled(false);
        buttonA.setBorderPainted(false);
        buttonA.setBounds(50,50,50,50);
        buttonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Image imgUsed = ImageIO.read(getClass().getResource("/material/element/b_Yes.png"));
                    buttonA.setIcon(new ImageIcon(imgUsed));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        this.add(buttonA);

        try {
            Image img = ImageIO.read(getClass().getResource("/material/element/b_No.png"));

            buttonB.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        buttonB.setContentAreaFilled(false);
        buttonB.setBorderPainted(false);
        buttonB.setBounds(50,110,50,50);
        buttonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("buttonB");
                try {
                    Image imgUsed = ImageIO.read(getClass().getResource("/material/element/b_Yes.png"));
                    buttonB.setIcon(new ImageIcon(imgUsed));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        this.add(buttonB);

        try {
            Image img = ImageIO.read(getClass().getResource("/material/element/b_No.png"));

            buttonC.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        buttonC.setContentAreaFilled(false);
        buttonC.setBorderPainted(false);
        buttonC.setBounds(50,170,50,50);
        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Image imgUsed = ImageIO.read(getClass().getResource("/material/element/b_Yes.png"));
                    buttonC.setIcon(new ImageIcon(imgUsed));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        this.add(buttonC);

        try {
            Image img = ImageIO.read(getClass().getResource("/material/element/b_No.png"));

            buttonD.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        buttonD.setContentAreaFilled(false);
        buttonD.setBorderPainted(false);
        buttonD.setBounds(50,230,50,50);
        buttonD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Image imgUsed = ImageIO.read(getClass().getResource("/material/element/b_Yes.png"));
                    buttonD.setIcon(new ImageIcon(imgUsed));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        this.add(buttonD);


        try {
            Image img = ImageIO.read(getClass().getResource("/material/items/test.gif"));

            buttonSwitch.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        buttonSwitch.setContentAreaFilled(false);
        buttonSwitch.setBorderPainted(false);
        buttonSwitch.setBounds(50,500,250,80);
        this.add(buttonSwitch);

        try {
            Image img = ImageIO.read(getClass().getResource("/material/element/b_No.png"));

            buttonMapSmall.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        buttonMapSmall.setContentAreaFilled(false);
        buttonMapSmall.setBorderPainted(false);
        buttonMapSmall.setBounds(50,650,45,45);
        buttonMapSmall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Image imgUsed = ImageIO.read(getClass().getResource("/material/element/b_Yes.png"));
                    buttonMapSmall.setIcon(new ImageIcon(imgUsed));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        this.add(buttonMapSmall);

        try {
            Image img = ImageIO.read(getClass().getResource("/material/element/b_No.png"));

            buttonMapMedium.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        buttonMapMedium.setContentAreaFilled(false);
        buttonMapMedium.setBorderPainted(false);
        buttonMapMedium.setBounds(250,650,45,45);
        buttonMapMedium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Image imgUsed = ImageIO.read(getClass().getResource("/material/element/b_Yes.png"));
                    buttonMapMedium.setIcon(new ImageIcon(imgUsed));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        this.add(buttonMapMedium);

        try {
            Image img = ImageIO.read(getClass().getResource("/material/element/b_No.png"));

            buttonMapLarge.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        buttonMapLarge.setContentAreaFilled(false);
        buttonMapLarge.setBorderPainted(false);
        buttonMapLarge.setBounds(450,650,45,45);
        buttonMapLarge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Image imgUsed = ImageIO.read(getClass().getResource("/material/element/b_Yes.png"));
                    buttonMapLarge.setIcon(new ImageIcon(imgUsed));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        this.add(buttonMapLarge);

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

}
