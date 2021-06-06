package view;

import model.Wuerfel;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;


public class DicePanel extends JPanel {

    public JButton wuerfelnButton;
    public JButton[] figureMoveButton;
    public int augenzahl;
    public int chosenFigure;

    public int getAugenzahl() {
        return augenzahl;
    }

    public DicePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //setBorder(BorderFactory.createLineBorder(java.awt.Color.WHITE, 5));
        figureMoveButton = new JButton[4];

        ImageIcon diceOne = new ImageIcon(getClass().getResource("images/wuerfel1.png"));
        ImageIcon diceTwo = new ImageIcon(getClass().getResource("images/wuerfel2.png"));
        ImageIcon diceThree = new ImageIcon(getClass().getResource("images/wuerfel3.png"));
        ImageIcon diceFour = new ImageIcon(getClass().getResource("images/wuerfel4.png"));
        ImageIcon diceFive = new ImageIcon(getClass().getResource("images/wuerfel5.png"));
        ImageIcon diceSix = new ImageIcon(getClass().getResource("images/wuerfel6.png"));

        JButton diceButton = new JButton();
//        diceButton.setPreferredSize(new Dimension(263, 263));
        diceButton.setAlignmentX(CENTER_ALIGNMENT);
        diceButton.setIcon(diceOne);
        add(diceButton);
        diceButton.setBackground(java.awt.Color.BLACK);
        diceButton.setMargin(new Insets(15, 15, 15, 15));
        diceButton.setBorderPainted(false);

        add(Box.createVerticalGlue());

        wuerfelnButton = new JButton("Roll dice");
        wuerfelnButton.setVisible(false);
        wuerfelnButton.setMaximumSize(new Dimension(263, 50));
        wuerfelnButton.setAlignmentX(CENTER_ALIGNMENT);
        wuerfelnButton.setBackground(java.awt.Color.WHITE);
        wuerfelnButton.addActionListener(e -> {

            augenzahl = Wuerfel.wuerfeln();

            System.out.println(augenzahl);


            if (augenzahl == 1){
                diceButton.setIcon(diceOne);
            }
            else if (augenzahl == 2){
                diceButton.setIcon(diceTwo);
            }
            else if (augenzahl == 3){
                diceButton.setIcon(diceThree);
            }
            else if (augenzahl == 4){
                diceButton.setIcon(diceFour);
            }
            else if (augenzahl == 5){
                diceButton.setIcon(diceFive);
            }
            else if (augenzahl == 6){
                diceButton.setIcon(diceSix);
            }

            wuerfelnButton.setVisible(false);

            for (int i = 0; i < figureMoveButton.length; i++) {
                figureMoveButton[i].setVisible(true);
            }
        });


        for (int i = 0; i < figureMoveButton.length; i++) {
            int j = i + 1;
            figureMoveButton[i] = new JButton("move Figure " + j);
            figureMoveButton[i].setMaximumSize(new Dimension(133, 50));
            figureMoveButton[i].setVisible(false);
            figureMoveButton[i].setBackground(Color.WHITE);
            figureMoveButton[i].setAlignmentX(CENTER_ALIGNMENT);
            figureMoveButton[i].setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK, 10));
            figureMoveButton[i].setMargin(new Insets(15, 15, 15, 15));


            add(figureMoveButton[i]);
        }


        figureMoveButton[0].addActionListener(e -> {
            chosenFigure = 0;
            for (int i = 0; i < figureMoveButton.length; i++) {
                figureMoveButton[i].setVisible(false);
            }
        });

        figureMoveButton[1].addActionListener(e -> {
            chosenFigure = 1;
            for (int i = 0; i < figureMoveButton.length; i++) {
                figureMoveButton[i].setVisible(false);
            }
        });

        figureMoveButton[2].addActionListener(e -> {
            chosenFigure = 2;
            for (int i = 0; i < figureMoveButton.length; i++) {
                figureMoveButton[i].setVisible(false);
            }
        });

        figureMoveButton[3].addActionListener(e -> {
            chosenFigure = 3;
            for (int i = 0; i < figureMoveButton.length; i++) {
                figureMoveButton[i].setVisible(false);
            }
        });

        add(wuerfelnButton);
    }
}
