package Model;

import View.Color;
import View.GameWindow;

public class Game {
    public Player[] players = new Player[4];
    public boolean isOver;
    public int currentPlayerIndex = -1;
    public GameWindow gameWindow;

    public Game(int playerColor) {

//        GameBoard gameBoard = new GameBoard();

        for (Color color : Color.values()) {
            players[color.ordinal()] = new Player(color);
            players[color.ordinal()].setHumanPlayer(playerColor == color.ordinal());
        }
    }

    public boolean isOver() {
        return players[currentPlayerIndex].isDone();
    }

    private void start() {
        gameWindow = new GameWindow();
        while (currentPlayerIndex == -1 || !isOver()) {
            currentPlayerIndex = (currentPlayerIndex + 1) % 4;
            Player currentPlayer = players[currentPlayerIndex];
            // if NPC, automatic dice and move
            // if human, human decide and move

            int steps = Wuerfel.wuerfeln();
            currentPlayer.report();
            currentPlayer.move(steps, players);
            currentPlayer.report();
            System.out.println();
            System.out.println();
            System.out.println();
        }

        System.out.println("Game over. Winner is " + players[currentPlayerIndex].getColor());
        players[currentPlayerIndex].report();

    }

    public static void main(String[] args) {
        new Game(1).start();
    }

}
