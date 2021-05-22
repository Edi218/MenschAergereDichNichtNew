package spiel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;


public class DicePanel extends JPanel {


    public DicePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));

        ImageIcon diceOne = new ImageIcon(getClass().getResource("images/wuerfel1.png"));
        ImageIcon diceTwo = new ImageIcon(getClass().getResource("images/wuerfel2.png"));
        ImageIcon diceThree = new ImageIcon(getClass().getResource("images/wuerfel3.png"));
        ImageIcon diceFour = new ImageIcon(getClass().getResource("images/wuerfel4.png"));
        ImageIcon diceFive = new ImageIcon(getClass().getResource("images/wuerfel5.png"));
        ImageIcon diceSix = new ImageIcon(getClass().getResource("images/wuerfel6.png"));

        JButton diceButton = new JButton();
//        diceButton.setPreferredSize(new Dimension(263, 263));
        diceButton.setAlignmentX(CENTER_ALIGNMENT);
        diceButton.setIcon(diceOne);
        add(diceButton);
        diceButton.setBackground(Color.BLACK);
        diceButton.setMargin(new Insets(15, 15, 15, 15));
        diceButton.setBorderPainted(false);

        add(Box.createVerticalGlue());

        JButton wuerfelnButton = new JButton("Würfeln");
        wuerfelnButton.setMaximumSize(new Dimension(263, 50));
        wuerfelnButton.setAlignmentX(CENTER_ALIGNMENT);
        wuerfelnButton.addActionListener(e -> {

            int augenzahl = Wuerfel.wuerfeln();

            System.out.println(augenzahl);


            if (augenzahl == 1){
                diceButton.setIcon(diceOne);
            }
            else if (augenzahl == 2){
                diceButton.setIcon(diceTwo);
            }
            else if (augenzahl == 3){
                diceButton.setIcon(diceThree);
            }
            else if (augenzahl == 4){
                diceButton.setIcon(diceFour);
            }
            else if (augenzahl == 5){
                diceButton.setIcon(diceFive);
            }
            else if (augenzahl == 6){
                diceButton.setIcon(diceSix);
            }

            wuerfelnButton.setVisible(false);
        });
        add(wuerfelnButton);
        wuerfelnButton.setBackground(Color.WHITE);
    }
}
