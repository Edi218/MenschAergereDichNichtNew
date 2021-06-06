package model;

import view.Color;
import view.DicePanel;
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



    public String oneMove(int playerColor, DicePanel dicePanel) {
        currentPlayerIndex = (currentPlayerIndex + 1) % 4;
        currentPlayer = players[currentPlayerIndex];
        if (currentPlayerIndex == playerColor){
            dicePanel.wuerfelnButton.setVisible(true);


            if (currentPlayer.isDone()) {
                System.out.println(currentPlayer.getColor().getText() + "is the Winner");
                newText = currentPlayer.getColor().getText() + "is the Winner";
            }
        } else{
            int steps = Wuerfel.wuerfeln();
            currentPlayer.report();
            newText = currentPlayer.move(steps, players);
            currentPlayer.report();
            System.out.println();
            System.out.println();
            System.out.println();
            if (currentPlayer.isDone()) {
                System.out.println(currentPlayer.getColor().getText() + "is the Winner");
                newText = currentPlayer.getColor().getText() + "is the Winner";
            }
        }
        return newText;
    }


}
