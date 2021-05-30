package View;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameBoard {
    public Field[] gameBoard = new Field[41];
    public TargetField[] blackTarget = new TargetField[4];
    public TargetField[] greenTarget = new TargetField[4];
    public TargetField[] redTarget = new TargetField[4];
    public TargetField[] yellowTarget = new TargetField[4];




    public GameBoard() {

        gameBoard[0] = new Field(0, 0);

        System.out.println("BAnane");

        int c = 0;

        for (int i = 1; i < 6; i++) {
            System.out.println(i);
            gameBoard[i] = new Field(310 + c, 230);
            System.out.println(i);
            c = c + 20;
        } // Feld 1-5

        c = 0;

        for (int i = 6; i < 10; i++) {
            System.out.println(i);
            gameBoard[i] = new Field(390, 210 - c);

            c = c + 20;
        } // Feld 6-9

        c = 0;

        for (int i = 10; i < 12; i++) {
            System.out.println(i);
            gameBoard[i] = new Field(410 + c, 150);

            c = c + 20;
        } // Feld 10-11

        c = 0;

        for (int i = 12; i < 16; i++) {

            gameBoard[i] = new Field(430, 170 + c);

            c = c + 20;
        } // Feld 12-15

        c = 0;

        for (int i = 16; i < 20; i++) {

            gameBoard[i] = new Field(450 + c, 230);

            c = c + 20;
        } // Feld 16-19

        c = 0;

        for (int i = 20; i < 22; i++) {

            gameBoard[i] = new Field(510, 250 + c);

            c = c + 20;
        } // Feld 20-21

        c = 0;

        for (int i = 22; i < 26; i++) {

            gameBoard[i] = new Field(490 - c, 270);

            c = c + 20;
        } // Feld 22-25

        c = 0;

        for (int i = 26; i < 30; i++) {

            gameBoard[i] = new Field(430, 290 + c);

            c = c + 20;
        } // Feld 26-29

        c= 0;

        for (int i = 30; i < 32; i++) {

            gameBoard[i] = new Field(410 + c, 350);

            c = c + 20;
        } // Feld 30-31

        c= 0;

        for (int i = 32; i < 36; i++) {

            gameBoard[i] = new Field(390, 330 - c);

            c = c + 20;
        } // Feld 32-35

        c = 0;

        for (int i = 36; i < 38; i++) {
            System.out.println(i);
            gameBoard[i] = new Field(370 - c, 270);

            c = c + 20;
        } // Feld 36-38

        c = 0;

        for (int i = 38; i < 40; i++) {

            gameBoard[i] = new Field(310, 270 - c);
            System.out.println(i);
            c = c + 20;
        } // Feld 39-40

        gameBoard[40] = new Field(0,0);

        c = 0;
        //Zielfeld schwarz
        for (int i = 0; i < 4; i++) {
            blackTarget[i] = new TargetField(330 + c, 250, Color.BLACK);
            c += 20;
        }

        c = 0;
        //Zielfeld grün
        for (int i = 0; i < 4; i++) {
            greenTarget[i] = new TargetField(410, 170 + c, Color.GREEN);
            c+= 20;
        }
        c = 0;
        //Zielfeld rot
        for (int i = 0; i < 4; i++) {
            redTarget[i] = new TargetField(490 - c, 250, Color.RED);
            c += 20;
        }
        c = 0;
        //Zielfeld gelb
        for (int i = 0; i < 4; i++) {
            yellowTarget[i] = new TargetField(410, 270 + c, Color.RED);
            c += 20;
        }
    }

    public static void drawCircle(Graphics2D g, int x, int y, int radius) {

        int diameter = radius * 2;

        g.fillOval(x - radius, y - radius, diameter, diameter);

    }



    public void drawGameBoard(Graphics2D g){
        g.setColor(java.awt.Color.BLACK);

        for (int i = 1; i < gameBoard.length; i++) {
            drawCircle(g, gameBoard[i].getX(), gameBoard[i].getY(), 5);
        }
        for (int i = 0; i < blackTarget.length; i++) {
            drawCircle(g, blackTarget[i].getX(), blackTarget[i].getY(), 5);
        }
        for (int i = 0; i < greenTarget.length; i++) {
            drawCircle(g, greenTarget[i].getX(), greenTarget[i].getY(), 5);
        }
        for (int i = 0; i < redTarget.length; i++) {
            drawCircle(g, redTarget[i].getX(), redTarget[i].getY(), 5);
        }
        for (int i = 0; i < yellowTarget.length; i++) {
            drawCircle(g, yellowTarget[i].getX(), yellowTarget[i].getY(), 5);
        }

    }

    public void testen () {
        for (int i = 0; i < gameBoard.length; i++) {

        }
    }

    public void drawGameBoard() {
    }
}
