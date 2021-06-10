package model;

import java.util.List;

public class Game {
    private int currentPlayerIndex = -1;
    private final Player[] players = new Player[4];

    public Game() {
        for (Color color : Color.values()) {
            players[color.ordinal()] = new Player(color);
        }
    }

    public boolean isOver() {
        return currentPlayerIndex != -1 && players[currentPlayerIndex].isDone();
    }

    public Player[] getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setHumanPlayerIndex(int humanPlayerIndex) {
        players[humanPlayerIndex].setHumanPlayer(true);
    }

    /**
     * Moves a figure of NPC player based on the best move strategy.
     * @return
     */
    public String npcMove() {
        Player currentPlayer = players[currentPlayerIndex];
        int steps = Wuerfel.wuerfeln();
        currentPlayer.report();
        String report = currentPlayer.move(steps, players);
        currentPlayer.report();
        System.out.println();
        System.out.println();
        System.out.println();
        return report;
    }

    /**
     * Moves a figure of human player based on his figure choice.
     * @param steps steps to move
     * @param chosenFigure figure to move
     */
    public void humanMove(int steps, int chosenFigure) {
        players[currentPlayerIndex].humanMove(steps, chosenFigure, players);
    }

    /**
     * This method determines a list of figures, which are allowed to move steps at all. Human player has to choose the figure to move out of this list.
     * @param steps number of steps.
     * @return a list of figure indexes.
     */
    public List<Integer> calculateShortList(int steps) {
        return players[currentPlayerIndex].calculateShortlist(steps);
    }

    public void turnToNextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % 4;
    }

}
