package spiel;

import com.sun.tools.javac.Main;

import java.util.Random;

public class testen {
    public int dicen() {
        Random random = new Random();
        int zahl = random.nextInt(6) + 1;
        return zahl;
    }

    public static void main(String[] args) {
        testen test = new testen();
        int number = test.dicen();
        System.out.println(number);
    }
}
