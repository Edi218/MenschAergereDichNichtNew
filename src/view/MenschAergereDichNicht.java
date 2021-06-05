package view;

import model.Game;

public class MenschAergereDichNicht {


    public static void main(String[] args) {

        // Model
        Game game = new Game(1);

//        game.simulate(4);



        // View
        new GameWindow(game);

//        GameBoard gameBoard = new GameBoard();


    }
}
