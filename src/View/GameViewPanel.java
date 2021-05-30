package View;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.util.Random;

public class GameViewPanel extends Canvas {

public Canvas getCanvas(){
    return (Canvas) this;
}

    public GameViewPanel(){
        super();
        setBounds(0, 0, 800, 800);
        setBackground(Color.BLUE);
    }
}
