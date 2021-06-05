package view;

import model.Game;

import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.awt.image.BufferStrategy;


public class GamePanel extends JPanel {

    public static final String IMAGE_DIR = "images/";

    private final Dimension prefSize = new Dimension(1180, 780);
    private final String[] backgroundImages = new String[]{"blackscreen.png", "schwarz.png"};
    private final Game game;
    public int playerColor;
    private JPanel titlePanel;
    private JPanel figurePanel;
    private JPanel gamePanel;
    private Image backgroundImage;
    private GameViewPanel gameViewPanel;
    private DicePanel dicePanel;
    private PlayerPanel playerPanel;
    private GameBoard gameBoard;
    private ReportPanel reportPanel;
    private String newText;


    public GamePanel(Game game) {
        this.game = game;
        setFocusable(true);
        setPreferredSize(prefSize);
        setLayout(new BorderLayout());

        titlePanel = new JPanel();
        titlePanel.setBackground(java.awt.Color.BLACK);
        JButton titleButton = new JButton("Bitte wählen Sie Ihre Farbe!");
        titleButton.setPreferredSize(new Dimension(200, 50));
        titleButton.setBackground(java.awt.Color.WHITE);
        titlePanel.add(titleButton);
        add(titlePanel, BorderLayout.NORTH);

        figurePanel = new JPanel();
        figurePanel.setBackground(java.awt.Color.BLACK);
        add(figurePanel, BorderLayout.CENTER);
        chooseColor();
    }

    public GameViewPanel getGameViewPanel() {
        return gameViewPanel;
    }

    public int getPlayerColor() {
        return playerColor;
    }

    public void chooseColor() {
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

    private void initGame() {
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

        reportPanel = new ReportPanel(newText);
        add(reportPanel, BorderLayout.SOUTH);
        reportPanel.setVisible(true);

        gameBoard = new GameBoard(game);
        initLoop();
    }

    private void initLoop() {
        showCurrentPlayer();
        final Runnable moveTask = () -> {
            render();
            newText = game.oneMove();
            showCurrentPlayer();
            showCurrentReport(newText);
            try {
                render();
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!game.isOver()) {
                initLoop();
            } else {
                System.out.println("Game over");
            }

        };
        final Runnable gameOverTask = () -> {
                JDialog meinJDialog = new JDialog();
                // Titel wird gesetzt
                meinJDialog.setTitle("Mein JDialog Beispiel");
                // Breite und Höhe des Fensters werden
                // auf 200 Pixel gesetzt
                meinJDialog.setSize(200,200);
                // Dialog wird auf modal gesetzt
                meinJDialog.setModal(true);
                // Wir lassen unseren Dialog anzeigen
                meinJDialog.setVisible(true);
        };
        if (game.isOver()) {
            SwingUtilities.invokeLater(gameOverTask);
        } else {
            SwingUtilities.invokeLater(moveTask);
        }
    }

    private void showCurrentPlayer() {

        for (int i = 0; i < playerPanel.playerIcons.length; i++) {
            if (i == game.currentPlayerIndex){
                playerPanel.playerIcons[i].setBackground(Color.YELLOW);
            } else{
                playerPanel.playerIcons[i].setBackground(Color.WHITE);
            }
        }

        playerPanel.revalidate();
    }

    private void showCurrentReport(String s) {

        reportPanel.reportButton.setText(s);

        reportPanel.revalidate();

    }

    public void render() {
        BufferStrategy bs = gameViewPanel.getBufferStrategy();
        while (bs == null) {
            gameViewPanel.createBufferStrategy(3);
            bs = gameViewPanel.getBufferStrategy();
        }
        Graphics2D g = (Graphics2D) bs.getDrawGraphics();
        g.clearRect(0, 0, gameViewPanel.getWidth(), gameViewPanel.getHeight());
        gameBoard.drawGameBoard(g); // in der methode steht alles was gemalt werden soll
        g.dispose();
        bs.show();
    }
//    public void update(Graphics g) {
//        g.clearRect(0, 0, gameViewPanel.getWidth(), gameViewPanel.getHeight());
//        gameBoard.drawGameBoard((Graphics2D) g); // in der methode steht alles was gemalt werden soll
//    }
}
