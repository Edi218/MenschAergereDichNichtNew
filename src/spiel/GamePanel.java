package spiel;

import java.io.IOException;
import java.net.URL;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;


public class GamePanel extends JPanel {

    public static final String IMAGE_DIR = "images/";

    private final Dimension prefSize = new Dimension(1180, 780);
    private final String[] backgroundImages= new String [] {"blackscreen.png", "schwarz.png"};

    private JPanel titlePanel;
    private JPanel figurePanel;
    public JPanel dicePanel;
    private Image backgroundImage;
    private boolean gameOver = false;
    private int figureOnTarget = 0;
    private Timer timer;
    public int playerColor;

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
        DicePanel dicePanel = new DicePanel();
        dicePanel.setBackground(java.awt.Color.BLACK);
        add(dicePanel, BorderLayout.EAST);
        dicePanel.setVisible(true);

        PlayerPanel playerPanel = new PlayerPanel();
        playerPanel.setBackground(java.awt.Color.WHITE);
        add(playerPanel, BorderLayout.WEST);
        playerPanel.setVisible(true);
    }


    private void initGame () {
        setBackgroundImage(0);
        titlePanel.setBackground(java.awt.Color.BLACK);
        figurePanel.setBackground(java.awt.Color.BLACK);
        chooseColor();
        createGameObjects();

        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doOnTick();
            }
        });
    }

    private void createGameObjects() {

    }

    private void initPlayersFigures() {

    }

    public void setBackgroundImage(int imageNumber) {
        String imagePath = IMAGE_DIR + backgroundImages[imageNumber];
        URL imageURL = getClass().getResource(imagePath);
        try {
            backgroundImage = ImageIO.read(imageURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startGame() {
        timer.start();
    }

    public void pauseGame() {
        timer.stop();
    }
    public
 void continueGame() {
        if (!isGameOver()) {
            timer.start();
        }
    }

    public void restartGame() {
        figureOnTarget = 0;
        setGameOver(false);
        createGameObjects();
        startGame();
    }

    private void endGame() {
        setGameOver(true);
        pauseGame();
    }

    private void doOnTick() {
        repaint();
    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this);
        }

//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//        backgroundImage.paintIcon(null, g, 0, 0);
//
//        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 19));
//        g.setColor(Color.BLUE);
//        g.drawString("Gewonnen " + figureOnTarget, 22, prefSize.height-5);
//
//        if (isGameOver()) {
//            g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
//            g.setColor(Color.RED);
//            g.drawString("GAME OVER!", prefSize.width/2 - 130, prefSize.height/5);
//        }
    }

}
