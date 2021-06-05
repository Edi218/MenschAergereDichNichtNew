package view;


import javax.swing.*;
import java.awt.*;


public class PlayerPanel extends JPanel {

    public JButton[] playerIcons;



    public PlayerPanel() {
        playerIcons = new JButton[4];

        ImageIcon black =  new ImageIcon(getClass().getResource("images/schwarzPlayerPanel.png"));
        ImageIcon red =  new ImageIcon(getClass().getResource("images/rotPlayerPanel.png"));
        ImageIcon green =  new ImageIcon(getClass().getResource("images/gruenPlayerPanel.png"));
        ImageIcon yellow =  new ImageIcon(getClass().getResource("images/gelbPlayerPanel.png"));


        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(java.awt.Color.WHITE, 5));

        playerIcons[1] = new JButton("grün       ", green);

        playerIcons[1].setBackground(java.awt.Color.WHITE);

        playerIcons[1].setMargin(new Insets(0, 0, 10, 0));

        playerIcons[1].setBorder(BorderFactory.createLineBorder(java.awt.Color.BLUE, 5));

        playerIcons[1].setBorderPainted(false);

        playerIcons[1].setVisible(true);


        playerIcons[2] = new JButton("rot           ", red);

        playerIcons[2].setBackground(java.awt.Color.WHITE);

        playerIcons[2].setMargin(new Insets(0, 0, 10, 0));

        playerIcons[2].setBorder(BorderFactory.createLineBorder(java.awt.Color.BLUE, 5));

        playerIcons[2].setBorderPainted(false);

        playerIcons[2].setVisible(true);


        playerIcons[0] = new JButton("schwarz", black);

        playerIcons[0].setBackground(java.awt.Color.WHITE);

        playerIcons[0].setMargin(new Insets(0, 0, 10, 0));

        playerIcons[0].setBorder(BorderFactory.createLineBorder(java.awt.Color.BLUE, 5));

        playerIcons[0].setBorderPainted(false);

        playerIcons[0].setVisible(true);


        playerIcons[3] = new JButton("gelb        ", yellow);

        playerIcons[3].setBackground(java.awt.Color.WHITE);

        playerIcons[3].setMargin(new Insets(0, 0, 10, 0));

        playerIcons[3].setBorder(BorderFactory.createLineBorder(java.awt.Color.BLUE, 5));

        playerIcons[3].setBorderPainted(false);

        playerIcons[3].setVisible(true);


        for (int i = 0; i < playerIcons.length; i++) {
            add(playerIcons[i]);
        }






    }
}

