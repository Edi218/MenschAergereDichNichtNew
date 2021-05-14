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


    public PlayerPanel() {
        ImageIcon player =  new ImageIcon("images/avatar.png");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

        JButton playerOne = new JButton();
        playerOne.setMaximumSize(new Dimension(300, 300));
        playerOne.setAlignmentX(CENTER_ALIGNMENT);
        playerOne.setIcon(player);

        JButton playerTwo = new JButton("Player2");
        JButton playerThree = new JButton("Player3");
        JButton playerFour = new JButton("Player4");





        add(playerOne);
//        add(playerTwo);
//        add(playerThree);
//        add(playerFour);






    }
}

