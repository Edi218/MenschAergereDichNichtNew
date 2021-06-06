package view;

import model.Figure;
import model.Game;
import model.Player;
import model.Position;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GameBoard {
    private final Game game;
    private final Field[] standardFields = new Field[41];
    private final Map<Color, StartField[]> startFields = new HashMap();
    private final Map<Color, TargetField[]> targetFields = new HashMap<>();
    private int fontSize;

   /* public TargetField[] blackTarget = new TargetField[4];
    public TargetField[] greenTarget = new TargetField[4];
    public TargetField[] redTarget = new TargetField[4];
    public TargetField[] yellowTarget = new TargetField[4];*/


/*
    public StartField[] blackStart = new StartField[4];
    public StartField[] greenStart = new StartField[4];
    public StartField[] redStart = new StartField[4];
    public StartField[] yellowStart = new StartField[4];
*/


    public GameBoard(Game game) {
        this.game = game;


        standardFields[0] = new Field(0, 0);
        int c = 0;
        for (int i = 1; i < 6; i++) {
            standardFields[i] = new Field(75 + c, 300);
            c = c + 50;
        } // Feld 1-5

        c = 0;

        for (int i = 6; i < 10; i++) {

            standardFields[i] = new Field(275, 250 - c);

            c = c + 50;
        } // Feld 6-9

        c = 0;

        for (int i = 10; i < 12; i++) {

            standardFields[i] = new Field(325 + c, 100);

            c = c + 50;
        } // Feld 10-11

        c = 0;

        for (int i = 12; i < 16; i++) {

            standardFields[i] = new Field(375, 150 + c);

            c = c + 50;
        } // Feld 12-15

        c = 0;

        for (int i = 16; i < 20; i++) {

            standardFields[i] = new Field(425 + c, 300);

            c = c + 50;
        } // Feld 16-19

        c = 0;

        for (int i = 20; i < 22; i++) {

            standardFields[i] = new Field(575, 350 + c);

            c = c + 50;
        } // Feld 20-21

        c = 0;

        for (int i = 22; i < 26; i++) {

            standardFields[i] = new Field(525 - c, 400);

            c = c + 50;
        } // Feld 22-25

        c = 0;

        for (int i = 26; i < 30; i++) {

            standardFields[i] = new Field(375, 450 + c);

            c = c + 50;
        } // Feld 26-29

        c = 0;

        for (int i = 30; i < 32; i++) {

            standardFields[i] = new Field(325 - c, 600);

            c = c + 50;
        } // Feld 30-31

        c = 0;

        for (int i = 32; i < 36; i++) {

            standardFields[i] = new Field(275, 550 - c);

            c = c + 50;
        } // Feld 32-35

        c = 0;

        for (int i = 36; i < 39; i++) {
            standardFields[i] = new Field(225 - c, 400);

            c = c + 50;
        } // Feld 36-38

        c = 0;

        for (int i = 39; i < 41; i++) {

            standardFields[i] = new Field(75, 400 - c);
            c = c + 50;
        } // Feld 39-40


        //Startfelder

        for (Color color : Color.values()) {
            StartField[] colorStartFields = new StartField[4];
            startFields.put(color, colorStartFields);
            int startX = 0;
            int startY = 0;
            switch (color) {
                case BLACK:
                    startX = 75;
                    startY = 100;
                    break;
                case GREEN:
                    startX = 525;
                    startY = 100;
                    break;
                case RED:
                    startX = 525;
                    startY = 550;
                    break;
                case YELLOW:
                    startX = 75;
                    startY = 550;
                    break;
            }
            for (int i = 0; i < 4; i++) {
                colorStartFields[i] = initStartField(i, startX, startY, color);
            }
        }

        //Zielfelder

        for (Color color : Color.values()) {
            TargetField[] colorTargetFields = new TargetField[4];
            targetFields.put(color, colorTargetFields);
            switch (color) {
                case BLACK:
                    c = 0;
                    for (int i = 0; i < 4; i++) {
                        colorTargetFields[i] = new TargetField(125 + c, 350, color);
                        c += 50;
                    }
                    break;
                case GREEN:
                    c = 0;
                    for (int i = 0; i < 4; i++) {
                        colorTargetFields[i] = new TargetField(325, 150 + c, color);
                        c += 50;
                    }
                    break;
                case RED:
                    c = 0;
                    for (int i = 0; i < 4; i++) {
                        colorTargetFields[i] = new TargetField(525 - c, 350, color);
                        c += 50;
                    }

                    break;
                case YELLOW:
                    c = 0;
                    for (int i = 0; i < 4; i++) {
                        colorTargetFields[i] = new TargetField(325, 550 - c, color);
                        c += 50;
                    }
                    break;
            }
        }
    }

    public static void drawCircle(Graphics2D g, int x, int y, int radius) {

        int diameter = radius * 2;

        g.fillOval(x - radius, y - radius, diameter, diameter);


    }

    private StartField initStartField(int index, int startX, int startY, Color color) {
        int x = index < 2 ? startX : startX + 50;
        int y = index % 2 == 0 ? startY : startY + 50;
        return new StartField(x, y, color);
    }

    public void drawGameBoard(Graphics2D g) {
        Map<StartField, Figure> startFieldMap = new HashMap<>();
        Map<Field, Figure> standardFieldMap = new HashMap<>();
        Map<TargetField, Figure> targetFieldMap = new HashMap<>();

        for (Player player : game.players) {
            for (Figure figure : player.figures) {
                Position position = figure.getPosition();
                if (position.isOnStart()) {
                    startFieldMap.put(startFields.get(player.getColor())[figure.id], figure);
                } else if (position.isOnStandard()) {
                    standardFieldMap.put(standardFields[position.getStandardPosition()], figure);
                } else {
                    targetFieldMap.put(targetFields.get(player.getColor())[position.getTargetPosition() - 1], figure);
                }
            }
        }


        drawStartFields(g, startFieldMap);
        drawStandardFields(g, standardFieldMap);
        drawTargetFields(g, targetFieldMap);
    }


    private void drawStandardFields(Graphics2D g, Map<Field, Figure> standardFigureMap) {
        fontSize = 20;
        for (int i = 1; i < standardFields.length; i++) {
            Field field = standardFields[i];
            Figure figure = standardFigureMap.get(field);
            if (figure == null) {
                g.setColor(java.awt.Color.WHITE);
                drawCircle(g, field.getX(), field.getY(), 15);
            } else {
                g.setColor(figure.getColor().getAwtColor());
                drawCircle(g, field.getX(), field.getY(), 15);
                g.setColor(figure.getColor().getAwtStringColor());
                g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
                g.drawString(String.valueOf(figure.getId() + 1),field.getX() - 6, field.getY() + 6);
                // Draw Index Digit
            }
        }
    }

    private void drawStartFields(Graphics2D g, Map<StartField, Figure> startFigureMap) {
        fontSize = 20;
        // loop field map
        // check for each field, whether figure available in figure map
        // depending on figure == null, draw Circle in diff colors
        startFields.entrySet().forEach(colorEntry -> {
            Color color = colorEntry.getKey();
            StartField[] colorStartFields = colorEntry.getValue();
            Arrays.stream(colorStartFields).forEach(startField -> {
                Figure figure = startFigureMap.get(startField);
                if (figure == null){
                    g.setColor(color.getAwtColor());
                    drawCircle(g, startField.getX(), startField.getY(), 15);
                } else {
                    g.setColor(color.getAwtColor());
                    drawCircle(g, startField.getX(), startField.getY(), 15);
                    g.setColor(figure.getColor().getAwtStringColor());
                    g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
                    g.drawString(String.valueOf(figure.getId() + 1),startField.getX() - 6, startField.getY() + 6);
                }
            });
        });
    }

    private void drawTargetFields(Graphics2D g, Map<TargetField, Figure> targetFigureMap) {
        fontSize = 20;
        targetFields.entrySet().forEach(colorEntry -> {
            Color color = colorEntry.getKey();
            TargetField[] colorTargetFields = colorEntry.getValue();
            Arrays.stream(colorTargetFields).forEach(targetField -> {
                Figure figure = targetFigureMap.get(targetField);
                g.setColor(color.getAwtColor());
                drawCircle(g, targetField.getX(), targetField.getY(), 15);
                if (figure != null){
                    g.setColor(figure.getColor().getAwtStringColor());
                    g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
                    g.drawString(String.valueOf(figure.getId() + 1),targetField.getX() - 6, targetField.getY() + 6);
                }
            });
        });

    }
}
