package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    public Figure[] figures = new Figure[4];
    private Color color;
    private boolean humanPlayer;

    public Player(Color color) {
        this.color = color;
        for (int i = 0; i < figures.length; i++) {
            figures[i] = new Figure(i, color);
        }
        humanPlayer = false;
    }

    public Figure[] getFigures() {
        return figures;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isHumanPlayer() {
        return humanPlayer;
    }

    public void setHumanPlayer(boolean humanPlayer) {
        this.humanPlayer = humanPlayer;
    }

    public String move(int steps, Player[] players) {
        List<Figure> shortlist = new ArrayList<>();
        List<Position> positionList = new ArrayList<>();
        checkClashWithSameColor(steps, shortlist, positionList);

        int bestMoveIndex = -1;
        Figure hitFigure = null;

        for (int i = 0; i < shortlist.size() && bestMoveIndex == -1; i++) {
            Figure figure = shortlist.get(i);
            Position position = positionList.get(i);
            boolean enemyClash = false;
            if (position.isOnTarget()) {
                // Good move because safe
                bestMoveIndex = i;
            } else {
                for (Player otherPlayer : players) {
                    if (otherPlayer == this) {
                        continue;
                    }
                    for (int j = 0; j < otherPlayer.getFigures().length; j++) {
                        if (position.equals(otherPlayer.getFigures()[j].getPosition())) {
                            // good move because hitting other figure
                            hitFigure = otherPlayer.getFigures()[j];
                            bestMoveIndex = i;
                            break;
                        }
                    }
                    if (bestMoveIndex != -1) {
                        break;
                    }
                }
            }
        }

        if (bestMoveIndex == -1) {
            bestMoveIndex = 0;
        }

        if (!shortlist.isEmpty()) {
            shortlist.get(bestMoveIndex).setPosition(positionList.get(bestMoveIndex));
            if (hitFigure != null) {
                hitFigure.restart();
                System.out.println("Figure " + hitFigure.getColor() + " hit and moved to start");
            }
            System.out.println("Player " + color + " moves " + steps + " steps");
            return  "Player " + color + " moves " + steps + " steps";
        } else {
            System.out.println("Player " + color + " can't move any figure.");
            return "Player " + color + " can't move any figure.";
        }
    }

    public List<Integer> calculateShortlist(int steps) {
        List<Figure> shortlist = new ArrayList<>();
        List<Position> positionList = new ArrayList<>();
        checkClashWithSameColor(steps, shortlist, positionList);
        return shortlist.stream().map(figure -> figure.getId()).collect(Collectors.toList());
    }

    public String humanMove(int steps, int figureId, Player[] players) {
        Figure hitFigure = null;
        Position newPosition = figures[figureId].simulateMove(steps);
        for (Player otherPlayer : players) {
            if (otherPlayer == this) {
                continue;
            }
            for (int j = 0; j < otherPlayer.getFigures().length; j++) {
                if (newPosition.equals(otherPlayer.getFigures()[j].getPosition())) {
                    // good move because hitting other figure
                    hitFigure = otherPlayer.getFigures()[j];
                    break;
                }
            }
            if (hitFigure != null) {
                break;
            }
        }
        figures[figureId].setPosition(newPosition);
        if (hitFigure != null) {
            hitFigure.restart();
            System.out.println("Figure " + hitFigure.getColor() + " hit and moved to start");
        }
        System.out.println("Player " + color + " moves " + steps + " steps");
        return "Player " + color + " moves " + steps + " steps";
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
