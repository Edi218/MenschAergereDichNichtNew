package view;

import java.awt.Color;
import java.awt.*;

public class GameViewPanel extends Canvas {

    public GameViewPanel() {
        super();
        setBounds(0, 0, 800, 800);
        setBackground(Color.pink);
    }

    public Canvas getCanvas() {
        return this;
    }
}
