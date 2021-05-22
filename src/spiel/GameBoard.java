package spiel;

import java.util.*;

public class GameBoard {
    public Field[] gameBoard = new Field[40];

    public GameBoard() {


        for (int i = 0; i < 5; i++) {

            int c = 0;
            gameBoard[i].setX(310 + c);
            gameBoard[i].setY(230);

            c = c + 20;
        } // Feld 1-5

        for (int i = 0; i < 4; i++) {

            int c = 0;
            gameBoard[i].setX(390);
            gameBoard[i].setY(210 - c);

            c = c + 20;
        } // Feld 6-9

        for (int i = 0; i < 2; i++) {

            int c = 0;
            gameBoard[i].setX(410 + c);
            gameBoard[i].setY(150);

            c = c + 20;
        } // Feld 10-11

        for (int i = 0; i < 4; i++) {

            int c = 0;
            gameBoard[i].setX(430);
            gameBoard[i].setY(170 + c);

            c = c + 20;
        } // Feld 12-15

        for (int i = 0; i < 4; i++) {

            int c = 0;
            gameBoard[i].setX(450 + c);
            gameBoard[i].setY(230);

            c = c + 20;
        } // Feld 16-19

        for (int i = 0; i < 2; i++) {

            int c = 0;
            gameBoard[i].setX(510);
            gameBoard[i].setY(250 + c);

            c = c + 20;
        } // Feld 20-21

        for (int i = 0; i < 4; i++) {

            int c = 0;
            gameBoard[i].setX(490 - c);
            gameBoard[i].setY(270);

            c = c + 20;
        } // Feld 22-25

        for (int i = 0; i < 4; i++) {

            int c = 0;
            gameBoard[i].setX(430);
            gameBoard[i].setY(290 + c);

            c = c + 20;
        } // Feld 26-29

        for (int i = 0; i < 2; i++) {

            int c = 0;
            gameBoard[i].setX(410 - c);
            gameBoard[i].setY(350);

            c = c + 20;
        } // Feld 30-31

        for (int i = 0; i < 4; i++) {

            int c = 0;
            gameBoard[i].setX(390);
            gameBoard[i].setY(330 - c);

            c = c + 20;
        } // Feld 32-35

        for (int i = 0; i < 3; i++) {

            int c = 0;
            gameBoard[i].setX(370 - c);
            gameBoard[i].setY(270);

            c = c + 20;
        } // Feld 36-38

        for (int i = 0; i < 4; i++) {

            int c = 0;
            gameBoard[i].setX(310);
            gameBoard[i].setY(270 - c);

            c = c + 20;
        } // Feld 39-40


        }


    public void testen () {
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.println(gameBoard[i].getX());
            System.out.println(gameBoard[i].getY());
        }
    }
}
