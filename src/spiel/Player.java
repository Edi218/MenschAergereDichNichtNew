package spiel;

import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player {
    public Figure[] figures = new Figure[4];
    int chosenFigure = 0;
    JButton figureOne = new JButton("Figur ziehen");
    JButton figureTwo = new JButton("Figur ziehen");
    JButton figureThree = new JButton("Figur ziehen");
    JButton figureFour = new JButton("Figur ziehen");
    private int playersOnTarget;
    private spiel.Color color;
    private boolean humanPlayer;


    public Player(spiel.Color color) {
        this.color = color;
        for (int i = 0; i < figures.length; i++) {
            figures[i] = new Figure(i, color);
        }
    }

    public int getPlayersOnTarget() {
        return playersOnTarget;
    }

    public void setPlayersOnTarget(int playersOnTarget) {
        this.playersOnTarget = playersOnTarget;
    }

    public Figure[] getFigures() {
        return figures;
    }

    public void setFigures(Figure[] figures) {
        this.figures = figures;
    }

    public spiel.Color getColor() {
        return color;
    }

    public void setColor(spiel.Color color) {
        this.color = color;
    }

    public boolean isHumanPlayer() {
        return humanPlayer;
    }

    public void setHumanPlayer(boolean humanPlayer) {
        this.humanPlayer = humanPlayer;
    }

    private void initializeButton(JButton jButton, JPanel jPanel, Figure figure) {
        figure.getPosition();
        jButton.setPreferredSize(new Dimension(100, 40));
        jButton.setBackground(java.awt.Color.WHITE);
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


    public void actionListener() {

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


    // NPC


    public void move(int steps, Player[] otherColorFigures) {
        List<Figure> shortlist = new ArrayList<>();
        List<Position> positionList = new ArrayList<>();
        checkClashWithSameColor(steps, shortlist, positionList);

        int bestMoveIndex = 0;
        Figure hitFigure = null;
        bestMoveIndex = calculateBestMove(otherColorFigures, shortlist, positionList, bestMoveIndex);

        if (!shortlist.isEmpty()) {
            shortlist.get(bestMoveIndex).setPosition(positionList.get(bestMoveIndex));
            if (hitFigure != null) {
                hitFigure.restart();
                System.out.println("Figure " + hitFigure.getColor() + " hit and moved to start");
            }
            System.out.println("Player " + color + " moves " + steps + " steps");
        } else {
            System.out.println("Player " + color + " can't move any figure.");
        }
    }

    private int calculateBestMove(Player[] players, List<Figure> shortlist, List<Position> positionList, int bestMoveIndex) {
        for (int i = 0; i < shortlist.size(); i++) {
            Figure figure = shortlist.get(i);
            Position position = positionList.get(i);
            boolean enemyClash = false;

            if (position.isOnTarget()) {
                // super zug
                bestMoveIndex = i;
                break;
            } else {
                for (Player otherPlayer : players) {
                    if (otherPlayer == this) {
                        continue;
                    }
                    for (int j = 0; j < otherPlayer.getFigures().length; j++) {

                            if (position.equals(figures[j].getPosition())) {
                                enemyClash = true;
                                break;
                            }

                    }


                    bestMoveIndex = i;
                    break;
                }
            }
        }
        return bestMoveIndex;
    }

    private void checkClashWithSameColor(int steps, List<Figure> shortlist, List<Position> positionList) {
        for (int i = 0; i < figures.length; i++) {
            Position position = figures[i].simulateMove(steps);
            if (position != null) {
                boolean clash = false;
                for (int j = 0; j < figures.length; j++) {
                    if (i != j) {
                        if (position.equals(figures[j].getPosition())) {
                            //-->clash
                            clash = true;
                            break;
                        }
                    }
                }
                if (!clash) {
                    shortlist.add(figures[i]);
                    positionList.add(position);
                }

            }
        }
    }


    public boolean isDone() {
        for (int i = 0; i < figures.length; i++) {
            if (!figures[i].isOnTarget()) {
                return false;
            }
        }
        return true;
    }

    public void report() {
        for (int i = 0; i < figures.length; i++) {
            System.out.println("Figure " + i + " at position " + figures[i].getPosition());
        }
    }
}
