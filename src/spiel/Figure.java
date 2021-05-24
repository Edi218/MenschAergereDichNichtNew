package spiel;

public class Figure {
    public int id;
    public Color color;
    /**
     * Current position of this figure. Index 1 - 40.
     * 0 = home
     */
    public int position;



    // TODO what about target fields

    public Figure(int id, Color color) {
        this.id = id;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(final Color color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(final int position) {
        this.position = position;
    }

    public void move(int steps) {
        if (position == 0) {
            position += color.startPosition + steps - 1;
        } else {
            position = (position + steps) % 40 ;
        }
        // target field handling.
    }
}
