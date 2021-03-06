package view;

import model.Game;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameWindow extends javax.swing.JFrame {

    private GamePanel gamePanel;
    private Game game;


    public GameWindow(Game game) {
        this.game = game;
        this.gamePanel = new GamePanel(game);
        createMenu();
        add(gamePanel);
        pack();
        setTitle("Mensch Ärgere Dich Nicht");
        setLocation(10, 10);
        setResizable(false);
        setVisible(true);
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        JMenu pause = new JMenu("Pause");
        menuBar.add(pause);
        addMenuItems(pause);
    }

    private void addMenuItems(JMenu fileMenu) {
        JMenuItem restart = new JMenuItem("Restart");
        fileMenu.add(restart);
        JMenuItem quit = new JMenuItem("Back To Hub");
        fileMenu.add(quit);

        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game1 = new Game();
                dispose();
                GameWindow gameWindow = new GameWindow(game1);
                gameWindow.setVisible(true);
            }
        });

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });
    }
}
