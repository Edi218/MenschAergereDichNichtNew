package spiel;

import java.io.IOException;
import java.net.URL;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;


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


    public GamePanel() {
        setFocusable(true);
        setPreferredSize(prefSize);
        setLayout(new BorderLayout());

        titlePanel = new JPanel();
        JButton titleButton = new JButton("Bitte wählen Sie Ihre Farbe!");
        titleButton.setPreferredSize(new Dimension(200, 50));
        titleButton.setBackground(Color.WHITE);
        titlePanel.add(titleButton);
        add(titlePanel, BorderLayout.NORTH);

        figurePanel = new JPanel();
        add(figurePanel, BorderLayout.CENTER);

        initGame();
        startGame();






//        dicePanel = new JPanel();
//        add(dicePanel, BorderLayout.EAST);
//        dicePanel.setLayout(new BoxLayout(dicePanel, BoxLayout.Y_AXIS));
//        dicePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
//        dicePanel.setVisible(false);
//        dicePanel.setOpaque(false);
        //Wuerfel wuerfel = new Wuerfel();

//        ImageIcon diceOne = new ImageIcon(getClass().getResource("images/wuerfel1.png"));
//        ImageIcon diceTwo = new ImageIcon(getClass().getResource("images/wuerfel2.png"));
//        ImageIcon diceThree = new ImageIcon(getClass().getResource("images/wuerfel3.png"));
//        ImageIcon diceFour = new ImageIcon(getClass().getResource("images/wuerfel4.png"));
//        ImageIcon diceFive = new ImageIcon(getClass().getResource("images/wuerfel5.png"));
//        ImageIcon diceSix = new ImageIcon(getClass().getResource("images/wuerfel6.png"));

        //JButton wuerfelButton = new JButton();
       // wuerfelButton.setPreferredSize(new Dimension(263, 263));
        //wuerfelButton.setIcon(diceOne);
        //dicePanel.add(wuerfelButton);
        //wuerfelButton.setBackground(Color.BLACK);
        //wuerfelButton.setBorderPainted(false);



        //JButton wuerfelnButton = new JButton("Würfeln");
        //wuerfelnButton.setSize(new Dimension(263, 50));
        //wuerfelnButton.setAlignmentX(CENTER_ALIGNMENT);
        //wuerfelnButton.addActionListener(e -> {
//            int augenzahl = wuerfel.wuerfeln();
//
//
//            System.out.println(augenzahl);
//
//
//            if (augenzahl == 1){
//                wuerfelButton.setIcon(diceOne);
//            }
//            if (augenzahl == 2){
//                wuerfelButton.setIcon(diceTwo);
//            }
//            if (augenzahl == 3){
//                wuerfelButton.setIcon(diceThree);
//            }
//            if (augenzahl == 4){
//                wuerfelButton.setIcon(diceFour);
//            }
//            if (augenzahl == 5){
//                wuerfelButton.setIcon(diceFive);
//            }
//            if (augenzahl == 6){
//                wuerfelButton.setIcon(diceSix);
//            }
//
//            wuerfelnButton.setVisible(false);
//        });
//        dicePanel.add(wuerfelnButton);
//        wuerfelnButton.setBackground(Color.WHITE);


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




        black.setPreferredSize(new Dimension(500, 200));
        black.setBackground(Color.WHITE);





        black.setBorder(BorderFactory.createLineBorder(Color.BLACK, 20));
        black.setMargin(new Insets(100, 100, 100, 100));
        black.addActionListener(e -> {
            hideButtons(black, green, red, yellow);

        });
        figurePanel.add(black);




        green.setPreferredSize(new Dimension(500, 200));
        green.setBackground(Color.WHITE);
        green.setBorder(BorderFactory.createLineBorder(Color.BLACK, 20));
        green.setMargin(new Insets(100, 100, 100, 100));
        green.addActionListener(e -> {
            hideButtons(black, green, red, yellow);
        });
        figurePanel.add(green);




        red.setPreferredSize(new Dimension(500, 200));
        red.setBackground(Color.WHITE);
        red.setBorder(BorderFactory.createLineBorder(Color.BLACK, 20));
        red.setMargin(new Insets(100, 100, 100, 100));
        red.addActionListener(e -> {
            hideButtons(black, green, red, yellow);
        });
        figurePanel.add(red);



        yellow.setPreferredSize(new Dimension(500, 200));
        yellow.setBackground(Color.WHITE);
        yellow.setBorder(BorderFactory.createLineBorder(Color.BLACK, 20));
        yellow.setMargin(new Insets(100, 100, 100, 100));
        yellow.addActionListener(e -> {
            hideButtons(black, green, red, yellow);
        });
        figurePanel.add(yellow, BorderLayout.CENTER);

    }

    public void hideButtons(JButton black, JButton green, JButton red, JButton yellow) {
        black.setVisible(false);
        green.setVisible(false);
        red.setVisible(false);
        yellow.setVisible(false);
        figurePanel.setVisible(false);
        titlePanel.setVisible(false);
        DicePanel dicePanel = new DicePanel();
        dicePanel.setBackground(Color.BLACK);
        add(dicePanel, BorderLayout.EAST);
        dicePanel.setVisible(true);

        PlayerPanel playerPanel = new PlayerPanel();
        playerPanel.setBackground(Color.BLACK);
        add(playerPanel, BorderLayout.WEST);
        playerPanel.setVisible(true);
    }


    private void initGame () {
        setBackgroundImage(0);
        titlePanel.setBackground(Color.BLACK);
        figurePanel.setBackground(Color.BLACK);
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
