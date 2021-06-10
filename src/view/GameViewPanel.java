package view;

import model.Game;

import javax.swing.*;
import java.awt.*;

public class GameViewPanel extends JPanel {

    private final GameBoard gameBoard;

    public GameViewPanel(Game game) {
        super();
        setBounds(0, 0, 800, 800);
        setBackground(Color.pink);
        gameBoard = new GameBoard(game);
    }

    @Override
    public void paint(Graphics g) {
//        BufferStrategy bs = getBufferStrategy();
//        while (bs == null) {
//            createBufferStrategy(3);
//            bs = getBufferStrategy();
//        }
//        Graphics2D g = (Graphics2D) bs.getDrawGraphics();
        g.clearRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.pink);
        g.fillRect(0, 0, getWidth(), getHeight());
        gameBoard.drawGameBoard((Graphics2D) g);
//        g.dispose();
//        bs.show();
    }
}
