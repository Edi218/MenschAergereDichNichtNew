package view;

public enum Color {

    BLACK(1, java.awt.Color.BLACK, java.awt.Color.WHITE, "Black "),
    GREEN(11, java.awt.Color.GREEN, java.awt.Color.BLACK, "Green "),
    RED(21, java.awt.Color.RED, java.awt.Color.WHITE, "Red "),
    YELLOW(31, java.awt.Color.YELLOW, java.awt.Color.BLACK, "Yellow ");

    private final int startPosition;
    private final java.awt.Color awtColor;
    private final java.awt.Color awtStringColor;
    private final String text;

    public java.awt.Color getAwtStringColor() {
        return awtStringColor;
    }


    public String getText() {
        return text;
    }

    Color(int startPosition, java.awt.Color awtColor, java.awt.Color awtStringColor, String text) {
        this.startPosition = startPosition;
        this.awtColor = awtColor;
        this.awtStringColor = awtStringColor;
        this.text = text;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public java.awt.Color getAwtColor() {
        return awtColor;
    }
}



