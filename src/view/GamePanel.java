package view;

import model.Game;

import javax.swing.*;
import java.awt.Color;
import java.awt.*;


public class GamePanel extends JPanel {

    public static final String IMAGE_DIR = "images/";

    private final Dimension prefSize = new Dimension(1180, 780);
    private final String[] backgroundImages = new String[]{"blackscreen.png", "schwarz.png"};
    private Game game;
    private JPanel titlePanel;
    private JPanel figurePanel;
    private Image backgroundImage;
    private GameViewPanel gameViewPanel;
    private DicePanel dicePanel;
    private PlayerPanel playerPanel;
    private ReportPanel reportPanel;
    private long delayInMilliSeconds;

    public GamePanel(Game game) {
        initGame(game);
    }

    private void initGame(Game game) {
        this.game = game;
        setFocusable(true);
        setPreferredSize(prefSize);
        setLayout(new BorderLayout());

        titlePanel = new JPanel();
        titlePanel.setBackground(Color.BLACK);
        JButton titleButton = new JButton("Choose your Color!");
        titleButton.setPreferredSize(new Dimension(200, 50));
        titleButton.setBackground(Color.WHITE);
        titlePanel.add(titleButton);
        add(titlePanel, BorderLayout.NORTH);

        figurePanel = new JPanel();
        figurePanel.setBackground(Color.BLACK);
        add(figurePanel, BorderLayout.CENTER);
        chooseColor();
    }

    public GameViewPanel getGameViewPanel() {
        return gameViewPanel;
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
        JButton npc = new JButton(d);

        initializeColor(black);
        initializeColor(green);
        initializeColor(red);
        initializeColor(yellow);
        initializeColor(npc);

        black.addActionListener(e -> {
            game.setHumanPlayerIndex(0);
            hideButtons(black, green, red, yellow);
        });
        green.addActionListener(e -> {
            game.setHumanPlayerIndex(1);
            hideButtons(black, green, red, yellow);
        });
        red.addActionListener(e -> {
            game.setHumanPlayerIndex(2);
            hideButtons(black, green, red, yellow);
        });
        yellow.addActionListener(e -> {
            game.setHumanPlayerIndex(3);
            hideButtons(black, green, red, yellow);
        });
        npc.addActionListener(e -> {
            hideButtons(black, green, red, yellow);
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
        figurePanel.setVisible(false);
        titlePanel.setVisible(false);
        initView();
    }

    private void initView() {
        dicePanel = new DicePanel(this, game);
        dicePanel.setBackground(java.awt.Color.BLACK);
        add(dicePanel, BorderLayout.EAST);
        dicePanel.setVisible(true);
        playerPanel = new PlayerPanel();
        playerPanel.setBackground(java.awt.Color.WHITE);
        add(playerPanel, BorderLayout.WEST);
        playerPanel.setVisible(true);

        gameViewPanel = new GameViewPanel(game);
        add(gameViewPanel, BorderLayout.CENTER);
        gameViewPanel.setVisible(true);

        reportPanel = new ReportPanel("Game starts!");
        add(reportPanel, BorderLayout.SOUTH);
        reportPanel.setVisible(true);
        move();
    }



    private void move() {
        // if NPC, enqueue next loop
        // otherwise, show dice button
        // dice button action listener --> calculateShortList, show figures button
        // figures button action listener --> humanMove, enqueue next NPC loop



        if (game.isOver()) {
            SwingUtilities.invokeLater(() -> {showEndDialog();});
            return;
        }
        game.turnToNextPlayer();
        showCurrentPlayer();
        if (game.getCurrentPlayer().isHumanPlayer()) {
            // show dice button
            dicePanel.showWuerfelnButton();
        } else {
            final Runnable moveTask = () -> {
                dicePanel.hideWuerfelnButton();
                String report = game.npcMove();
                showCurrentReport(report);
                gameViewPanel.repaint();
                delay();


                SwingUtilities.invokeLater(() -> {move();});
            };
            SwingUtilities.invokeLater(moveTask);
        }
    }

    private void showEndDialog() {
        System.err.println("Winner is " + game.getCurrentPlayer().getColor().getText());
        JDialog jDialog = new JDialog();
        jDialog.setTitle(game.getCurrentPlayer().getColor().getText() + "is the Winner");
        jDialog.setSize(200,200);
        jDialog.setModal(true);
        jDialog.setVisible(true);
    }

    private void delay() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


//    private void npcMove() {
//        // if NPC, enqueue next loop
//        // otherwise, show dice button
//        // dice button action listener --> calculateShortList, show figures button
//        // figures button action listener --> humanMove, enqueue next NPC loop
//
//
//
//        showCurrentPlayer();
//        final Runnable moveTask = () -> {
//            try {
//                gameViewPanel.repaint();
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            dicePanel.hideWuerfelnButton();
//            newText = game.npcMove(playerColor);
//            showCurrentPlayer();
//            showCurrentReport(newText);
//            if (!game.isOver()) {
//                //if npc, init, else human move
//                npcMove();
//            } else {
//                System.out.println("Game over");
//            }
//
//        };
//        final Runnable gameOverTask = () -> {
//
//        };
//        if (game.isOver()) {
//            SwingUtilities.invokeLater(gameOverTask);
//        } else {
//            SwingUtilities.invokeLater(moveTask);
//        }
//    }

    private void showCurrentPlayer() {

        for (int i = 0; i < playerPanel.playerIcons.length; i++) {
            if (i == game.getCurrentPlayerIndex()) {
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

    public void humanMove(int chosenFigure) {
        game.humanMove(dicePanel.getSteps(), chosenFigure);
        gameViewPanel.repaint();
        SwingUtilities.invokeLater(() -> {move();});
    }
}
