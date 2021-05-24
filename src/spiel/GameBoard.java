package spiel;

import java.util.*;

public class GameBoard {
    public Field[] gameBoard = new Field[41];

    public GameBoard() {


        int c = 0;

        for (int i = 1; i < 6; i++) {

            gameBoard[i].setX(310 + c);
            gameBoard[i].setY(230);

            c = c + 20;
        } // Feld 1-5

        c = 0;

        for (int i = 6; i < 10; i++) {


            gameBoard[i].setX(390);
            gameBoard[i].setY(210 - c);

            c = c + 20;
        } // Feld 6-9

        c = 0;

        for (int i = 10; i < 12; i++) {


            gameBoard[i].setX(410 + c);
            gameBoard[i].setY(150);

            c = c + 20;
        } // Feld 10-11

        c = 0;

        for (int i = 12; i < 16; i++) {


            gameBoard[i].setX(430);
            gameBoard[i].setY(170 + c);

            c = c + 20;
        } // Feld 12-15

        c = 0;

        for (int i = 16; i < 20; i++) {


            gameBoard[i].setX(450 + c);
            gameBoard[i].setY(230);

            c = c + 20;
        } // Feld 16-19

        c = 0;

        for (int i = 20; i < 22; i++) {

            gameBoard[i].setX(510);
            gameBoard[i].setY(250 + c);

            c = c + 20;
        } // Feld 20-21

        c = 0;

        for (int i = 22; i < 26; i++) {

            gameBoard[i].setX(490 - c);
            gameBoard[i].setY(270);

            c = c + 20;
        } // Feld 22-25

        c = 0;

        for (int i = 26; i < 30; i++) {


            gameBoard[i].setX(430);
            gameBoard[i].setY(290 + c);

            c = c + 20;
        } // Feld 26-29

        c= 0;

        for (int i = 30; i < 32; i++) {

            gameBoard[i].setX(410 - c);
            gameBoard[i].setY(350);

            c = c + 20;
        } // Feld 30-31

        c= 0;

        for (int i = 32; i < 36; i++) {


            gameBoard[i].setX(390);
            gameBoard[i].setY(330 - c);

            c = c + 20;
        } // Feld 32-35

        c = 0;

        for (int i = 36; i < 38; i++) {


            gameBoard[i].setX(370 - c);
            gameBoard[i].setY(270);

            c = c + 20;
        } // Feld 36-38

        c = 0;

        for (int i = 38; i < 40; i++) {

            gameBoard[i].setX(310);
            gameBoard[i].setY(270 - c);

            c = c + 20;
        } // Feld 39-40


    }

    public void drawGameBoard(){
        for (int i = 0; i < gameBoard.length; i++) {

        }
    }

    public void testen () {
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.println(gameBoard[i].getX());
            System.out.println(gameBoard[i].getY());
        }
    }
}
