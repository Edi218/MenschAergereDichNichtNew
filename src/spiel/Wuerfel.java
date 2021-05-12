package spiel;

import java.util.Random;


public class Wuerfel {
    public int wuerfeln(){
        Random random = new Random();
        int augenzahl = random.nextInt(6) + 1;
        return augenzahl;
    }
}
