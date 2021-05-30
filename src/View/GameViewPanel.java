package View;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.util.Random;

public class GameViewPanel extends Canvas {



    public GameViewPanel(){
        GameBoard gameBoard = new GameBoard();
        setBackground(java.awt.Color.RED);
        setBounds(new Rectangle(500, 500));
        gameBoard.render();
    }
}
