package spiel;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;


public class PlayerPanel extends JPanel {

    ImageIcon player =  new ImageIcon("images/avatar.png");

    public PlayerPanel() {
        ImageIcon player =  new ImageIcon("images/avatar.png");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
        add(Box.createVerticalGlue());

        JLabel playerOne = new JLabel("Player1", player, JLabel.CENTER);
        JLabel playerTwo = new JLabel("Player2");
        JLabel playerThree = new JLabel("Player3");
        JLabel playerFour = new JLabel("Player4");

        playerOne.setSize(new Dimension(50, 20));
        playerTwo.setSize(new Dimension(50, 20));
        playerThree.setSize(new Dimension(50, 20));
        playerFour.setSize(new Dimension(50, 20));

        playerOne.setForeground(Color.WHITE);

        add(playerOne);
        add(playerTwo);
        add(playerThree);
        add(playerFour);






    }
}

