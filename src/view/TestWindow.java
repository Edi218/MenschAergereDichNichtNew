package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TestWindow extends javax.swing.JFrame {

    public TestWindow() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(new DicePanel(), BorderLayout.EAST);
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
                TestWindow gameWindow = new TestWindow();
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

        new TestWindow();

    }

}
