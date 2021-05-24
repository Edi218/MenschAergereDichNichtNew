import spiel.Figure;

import javax.swing.*;
import java.awt.*;

public class Player {
    public int playersOnTarget;
    public Figure[] figures = new Figure[4];
    public int color;
    int chosenFigure = 0;


    public void initializeFigures(){
        for (int i = 0; i < figures.length; i++) {
            figures[i].setPosition(39);
        }
    }




    JButton figureOne = new JButton("Figur ziehen");
    JButton figureTwo = new JButton("Figur ziehen");
    JButton figureThree = new JButton("Figur ziehen");
    JButton figureFour = new JButton("Figur ziehen");



    private void initializeButton(JButton jButton, JPanel jPanel, Figure figure) {
        figure.getPosition();
        jButton.setPreferredSize(new Dimension(100, 40));
        jButton.setBackground(Color.WHITE);
        jButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 20));
        actionListener();
        jPanel.add(jButton);
    }

    public void hideButtons(JButton figureOne, JButton figureTwo, JButton figureThree, JButton figureFour) {
        figureOne.setVisible(false);
        figureTwo.setVisible(false);
        figureThree.setVisible(false);
        figureFour.setVisible(false);
    }


    public void actionListener(){

        figureOne.addActionListener(e -> {
            hideButtons(figureOne, figureTwo, figureThree, figureFour);
            chosenFigure = 1;
        });
        figureTwo.addActionListener(e -> {
            hideButtons(figureOne, figureTwo, figureThree, figureFour);
            chosenFigure = 2;
        });
        figureThree.addActionListener(e -> {
            hideButtons(figureOne, figureTwo, figureThree, figureFour);
            chosenFigure = 3;
        });
        figureFour.addActionListener(e -> {
            hideButtons(figureOne, figureTwo, figureThree, figureFour);
            chosenFigure = 4;
        });
    }


    // Human
    public void move(int chosenFigure, int steps) {
        figures[chosenFigure - 1].move(steps);
    }


    // NPC
    public void move(int steps) {
        // check, which figure can move steps
        // select, which is the best of possible moves

        int chosenFigure = 2;
        figures[chosenFigure - 1].move(steps);
        // execute the best choice
    }


    public void moveFigure(int gewuerfelteZahl, int chosenFigure){
        int oldPosition = figures[chosenFigure - 1].getPosition();
        int newPosition = oldPosition + gewuerfelteZahl;
        figures[chosenFigure - 1].setPosition(newPosition);
    }
}
