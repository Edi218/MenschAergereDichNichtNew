package view;

import model.Game;

public class MenschAergereDichNicht {


    public static void main(String[] args) {
        // Model
        Game game = new Game();
//        game.simulate(4);
        // View
        new GameWindow(game);
    }
}
