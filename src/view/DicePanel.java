package view;

import model.Game;
import model.Wuerfel;

import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.util.Arrays;
import java.util.List;


public class DicePanel extends JPanel {

    private final GamePanel gamePanel;
    private final Game game;
    public int steps;
    public int chosenFigure;
    private final JButton diceButton;
    private final JButton[] figureMoveButton;
    private final JButton diceImageButton;

    public DicePanel(GamePanel gamePanel, Game game) {
        this.game = game;
        this.gamePanel = gamePanel;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);
        //setBorder(BorderFactory.createLineBorder(java.awt.Color.WHITE, 5));
        figureMoveButton = new JButton[4];

        ImageIcon diceOne = new ImageIcon(getClass().getResource("images/wuerfel1.png"));
        ImageIcon diceTwo = new ImageIcon(getClass().getResource("images/wuerfel2.png"));
        ImageIcon diceThree = new ImageIcon(getClass().getResource("images/wuerfel3.png"));
        ImageIcon diceFour = new ImageIcon(getClass().getResource("images/wuerfel4.png"));
        ImageIcon diceFive = new ImageIcon(getClass().getResource("images/wuerfel5.png"));
        ImageIcon diceSix = new ImageIcon(getClass().getResource("images/wuerfel6.png"));

        diceImageButton = new JButton();
//        diceButton.setPreferredSize(new Dimension(263, 263));
        diceImageButton.setAlignmentX(CENTER_ALIGNMENT);
        diceImageButton.setIcon(diceOne);
        add(diceImageButton);
        diceImageButton.setBackground(java.awt.Color.BLACK);
        diceImageButton.setMargin(new Insets(15, 15, 15, 15));
        diceImageButton.setBorderPainted(false);

        add(Box.createVerticalGlue());

        diceButton = new JButton("Roll dice");
        diceButton.setVisible(false);
        diceButton.setMaximumSize(new Dimension(263, 80));
        diceButton.setMinimumSize(new Dimension(263, 80));
        diceButton.setAlignmentX(CENTER_ALIGNMENT);
        diceButton.setBackground(java.awt.Color.WHITE);
        diceButton.addActionListener(e -> {
            steps = Wuerfel.wuerfeln();
            System.out.println(steps);
            if (steps == 1) {
                diceImageButton.setIcon(diceOne);
            } else if (steps == 2) {
                diceImageButton.setIcon(diceTwo);
            } else if (steps == 3) {
                diceImageButton.setIcon(diceThree);
            } else if (steps == 4) {
                diceImageButton.setIcon(diceFour);
            } else if (steps == 5) {
                diceImageButton.setIcon(diceFive);
            } else if (steps == 6) {
                diceImageButton.setIcon(diceSix);
            }
            diceButton.setEnabled(false);

            List<Integer> shortList = game.calculateShortList(steps);

            for (int i = 0; i < figureMoveButton.length; i++) {
                figureMoveButton[i].setVisible(shortList.contains(i));
            }
        });

        for (int i = 0; i < figureMoveButton.length; i++) {
            figureMoveButton[i] = new JButton("move figure " + (i + 1));
            figureMoveButton[i].setMaximumSize(new Dimension(133, 50));
            figureMoveButton[i].setVisible(false);
            figureMoveButton[i].setBackground(Color.WHITE);
            figureMoveButton[i].setAlignmentX(CENTER_ALIGNMENT);
            figureMoveButton[i].setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK, 10));
            figureMoveButton[i].setMargin(new Insets(15, 15, 15, 15));

            figureMoveButton[i].addActionListener(e -> {
                String text = ((JButton) e.getSource()).getText();
                String indexText = text.substring(text.lastIndexOf(" ") + 1);
                chosenFigure = Integer.parseInt(indexText) - 1;
                hideAllFigureButtons();

                // tell the game to move the chosen figure. change to event listener in future
                gamePanel.humanMove(chosenFigure);
                

            });
            add(figureMoveButton[i]);
        }
        add(diceButton);
    }

    private void hideAllFigureButtons() {
        Arrays.stream(figureMoveButton).forEach(button -> button.setVisible(false));
    }

    public int getSteps() {
        return steps;
    }

    public void hideWuerfelnButton() {
        diceButton.setEnabled(false);
        //diceImageButton.setVisible(false);
        hideAllFigureButtons();
    }

    public void showWuerfelnButton() {
        diceButton.setVisible(true);
        diceImageButton.setVisible(true);
        diceButton.setEnabled(true);
    }
}
