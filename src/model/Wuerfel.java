package model;

import java.util.Random;


public class Wuerfel {
    public static int wuerfeln(){
        Random random = new Random();
        int augenzahl = random.nextInt(6) + 1;
        return augenzahl;
    }
}
