import spiel.Figure;
import spiel.GameBoard;
import spiel.Wuerfel;

public class Game {
    public Player[] players = new Player[4];
    public boolean isOver;
    public int currentPlayerIndex = 0;

    public Game(){

        GameBoard gameBoard = new GameBoard();
        for (int i = 0; i < players.length; i++) {
            players[i].initializeFigures();
        }


        while(!isOver){
            Player currentPlayer = players[currentPlayerIndex % 4];
            // if NPC, automatic dice and move
            // if human, human decide and move
            Wuerfel.wuerfeln();
            int steps = ;
            currentPlayerIndex++;
        }
    }

}
