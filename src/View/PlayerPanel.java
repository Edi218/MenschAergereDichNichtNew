package View;


import javax.swing.*;
import java.awt.*;


public class PlayerPanel extends JPanel {


    public PlayerPanel() {
        ImageIcon player =  new ImageIcon(getClass().getResource("images/avatar.png"));


        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(java.awt.Color.WHITE, 5));

        JButton playerOne = new JButton("grün       ", player);

        playerOne.setBackground(java.awt.Color.WHITE);

        playerOne.setMargin(new Insets(0, 0, 10, 0));

        playerOne.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLUE, 5));

        playerOne.setBorderPainted(false);

        playerOne.setVisible(true);


        JButton playerTwo = new JButton("rot           ", player);

        playerTwo.setBackground(java.awt.Color.WHITE);

        playerTwo.setMargin(new Insets(0, 0, 10, 0));

        playerTwo.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLUE, 5));

        playerTwo.setBorderPainted(false);

        playerTwo.setVisible(true);


        JButton playerThree = new JButton("schwarz", player);

        playerThree.setBackground(java.awt.Color.WHITE);

        playerThree.setMargin(new Insets(0, 0, 10, 0));

        playerThree.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLUE, 5));

        playerThree.setBorderPainted(false);

        playerThree.setVisible(true);


        JButton playerFour = new JButton("gelb        ", player);

        playerFour.setBackground(java.awt.Color.WHITE);

        playerFour.setMargin(new Insets(0, 0, 10, 0));

        playerFour.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLUE, 5));

        playerFour.setBorderPainted(false);

        playerFour.setVisible(true);






        add(playerOne);
        add(playerTwo);
        add(playerThree);
        add(playerFour);






    }
}

