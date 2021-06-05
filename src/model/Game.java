package model;

import view.Color;
import view.GameWindow;

public class Game {
    public Player[] players = new Player[4];
    public int currentPlayerIndex = -1;
    public Player currentPlayer;
    public String newText;

    public Game(int playerColor) {

//        GameBoard gameBoard = new GameBoard();

        for (Color color : Color.values()) {
            players[color.ordinal()] = new Player(color);
            players[color.ordinal()].setHumanPlayer(playerColor == color.ordinal());
        }
    }

    public boolean isOver() {
        return currentPlayerIndex != -1 && players[currentPlayerIndex].isDone();
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    private void start() {
        while (currentPlayerIndex == -1 || !isOver()) {
            currentPlayerIndex = (currentPlayerIndex + 1) % 4;
            oneMove();
        }

        System.out.println("Game over. Winner is " + players[currentPlayerIndex].getColor());
        players[currentPlayerIndex].report();
    }

    public static void main(String[] args) {
        new Game(1).start();
    }

    public String oneMove() {
        currentPlayerIndex = (currentPlayerIndex + 1) % 4;
        currentPlayer = players[currentPlayerIndex];
        int steps = Wuerfel.wuerfeln();
        currentPlayer.report();
        newText = currentPlayer.move(steps, players);
        currentPlayer.report();
        System.out.println();
        System.out.println();
        System.out.println();
        if (currentPlayer.isDone()) {
            System.out.println(currentPlayer.getColor().getText() + "is the Winner");
        }
        return newText;
    }
}
