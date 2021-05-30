package View;

import Model.Game;

import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.net.URL;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;


public class GamePanel extends JPanel {

    public static final String IMAGE_DIR = "images/";

    private final Dimension prefSize = new Dimension(1180, 780);
    private final String[] backgroundImages= new String [] {"blackscreen.png", "schwarz.png"};

    private JPanel titlePanel;
    private JPanel figurePanel;
    private JPanel gamePanel;
    private Image backgroundImage;
    private boolean gameOver = false;
    private Timer timer;
    public int playerColor;
    private GameViewPanel gameViewPanel;
    private DicePanel dicePanel;
    private PlayerPanel playerPanel;
    private GameBoard gameBoard;


    public GameViewPanel getGameViewPanel() {
        return gameViewPanel;
    }

    public GamePanel() {

        setFocusable(true);
        setPreferredSize(prefSize);
        setLayout(new BorderLayout());

        titlePanel = new JPanel();
        JButton titleButton = new JButton("Bitte wählen Sie Ihre Farbe!");
        titleButton.setPreferredSize(new Dimension(200, 50));
        titleButton.setBackground(java.awt.Color.WHITE);
        titlePanel.add(titleButton);
        add(titlePanel, BorderLayout.NORTH);

        figurePanel = new JPanel();
        add(figurePanel, BorderLayout.CENTER);



        chooseColor();
        Game game = new Game(playerColor);
    }

    public int getPlayerColor(){
        return playerColor;
    }




    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }



    public void chooseColor(){


        ImageIcon a = new ImageIcon(getClass().getResource("images/schwarz.png"));
        ImageIcon b = new ImageIcon(getClass().getResource("images/gruen.png"));
        ImageIcon c = new ImageIcon(getClass().getResource("images/rot.png"));
        ImageIcon d = new ImageIcon(getClass().getResource("images/gelb.png"));

        JButton black = new JButton(a);
        JButton green = new JButton(b);
        JButton red = new JButton(c);
        JButton yellow = new JButton(d);


        initializeColor(black);
        initializeColor(green);
        initializeColor(red);
        initializeColor(yellow);

        black.addActionListener(e -> {
            hideButtons(black, green, red, yellow);
            playerColor = 0;
        });
        green.addActionListener(e -> {
            hideButtons(black, green, red, yellow);
            playerColor = 1;
        });
        red.addActionListener(e -> {
            hideButtons(black, green, red, yellow);
            playerColor = 2;
        });
        yellow.addActionListener(e -> {
            hideButtons(black, green, red, yellow);
            playerColor = 3;
        });
    }






    private void initializeColor(JButton jButton) {
        jButton.setPreferredSize(new Dimension(500, 200));
        jButton.setBackground(java.awt.Color.WHITE);
        jButton.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK, 20));
        jButton.setMargin(new Insets(100, 100, 100, 100));

        figurePanel.add(jButton);
    }

    public void hideButtons(JButton black, JButton green, JButton red, JButton yellow) {
        black.setVisible(false);
        green.setVisible(false);
        red.setVisible(false);
        yellow.setVisible(false);
        figurePanel.setVisible(false);
        titlePanel.setVisible(false);

        initGame();
    }

    private void initGame(){
        dicePanel = new DicePanel();
        dicePanel.setBackground(java.awt.Color.BLACK);
        add(dicePanel, BorderLayout.EAST);
        dicePanel.setVisible(true);

        playerPanel = new PlayerPanel();
        playerPanel.setBackground(java.awt.Color.WHITE);
        add(playerPanel, BorderLayout.WEST);
        playerPanel.setVisible(true);

        gameViewPanel = new GameViewPanel();
        add(gameViewPanel, BorderLayout.CENTER);
        gameViewPanel.setVisible(true);

        gameBoard = new GameBoard();
        while (true) {
            render();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void render(){
        BufferStrategy bs = gameViewPanel.getBufferStrategy();
        while (bs == null) {
            gameViewPanel.createBufferStrategy(3);
            bs = gameViewPanel.getBufferStrategy();
        }

        Graphics2D g = (Graphics2D) bs.getDrawGraphics();

        g.clearRect(0, 0, 500, 500);


        gameBoard.drawGameBoard(g); // in der methode steht alles was gemalt werden soll

        g.dispose();
        bs.show();


    }






//    @Override
//    public void paintComponent (Graphics g) {
//        super.paintComponent(g);
//
//        if (backgroundImage != null) {
//            g.drawImage(backgroundImage, 0, 0, this);
//        }
//
////        Graphics2D g2d = (Graphics2D) g;
////        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
////
////        backgroundImage.paintIcon(null, g, 0, 0);
////
////        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 19));
////        g.setColor(Color.BLUE);
////        g.drawString("Gewonnen " + figureOnTarget, 22, prefSize.height-5);
////
////        if (isGameOver()) {
////            g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
////            g.setColor(Color.RED);
////            g.drawString("GAME OVER!", prefSize.width/2 - 130, prefSize.height/5);
////        }
//    }

}
