package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ReportPanel extends JPanel {

    public JButton reportButton;

    public ReportPanel(String report){
        setBackground(Color.WHITE);
        reportButton = new JButton(report);
        reportButton.setBackground(Color.WHITE);
        reportButton.setBorderPainted(false);
        reportButton.setVisible(true);

        add(reportButton);
    }
}
