package spiel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameWindow extends javax.swing.JFrame {

    private final GamePanel gamePanel;

    public GameWindow() {

        this.gamePanel = new GamePanel();

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
                setVisible(false);
                dispose();
                GameWindow gameWindow = new GameWindow();
            }
        });

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });
    }



    public static void main (String[] args){

        new GameWindow();

    }

}
