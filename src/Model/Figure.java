package Model;

import View.Color;

public class Figure {
    public int id;
    public Color color;
    /**
     * Current position of this figure. Index 1 - 40.
     * 0 = home
     */
    public Position position;


    public Figure(int id, Color color) {
        this.id = id;
        this.color = color;
        this.position = new Position(0, null);
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


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position simulateMove(int steps) {
        Integer newTargetPosition = null;
        Integer newStandardPosition = null;

        if (position.getStandardPosition() != null) {
            boolean lastQuarter = position.getStandardPosition() != null && position.getStandardPosition() >= ((color.startPosition + 40 - 10) % 40) && position.getStandardPosition() <= (color.startPosition == 1 ? 40 : ((color.startPosition + 40 - 1) % 40));
            int maxStandardPosition = color.startPosition == 1 ? 40 : color.startPosition - 1;
            int maxTargetPosition = 4;
            newStandardPosition = position.getStandardPosition() == 0 ? color.startPosition - 1 + steps : position.getStandardPosition() + steps;

            //noch nicht letztes Viertel

            if (!lastQuarter) {
                return new Position(newStandardPosition % 40, null);

            } else {
                if (position.getStandardPosition() + steps <= maxStandardPosition) {
                    return new Position(newStandardPosition % 40, null);
                } else {
                    newTargetPosition = newStandardPosition % maxStandardPosition;
                    if (newTargetPosition > maxTargetPosition) {
                        return null;
                    } else {
                        return new Position(null, newTargetPosition);
                    }
                }
            }
        } else {
            newTargetPosition = position.getTargetPosition() + steps;
            if (newTargetPosition > 4) {
                return null;
            } else {
                return new Position(null, newTargetPosition);
            }
        }

    }

    public boolean isOnTarget() {
        return position.isOnTarget();
    }

    public void restart() {
        this.position = new Position(0, null);
    }
}
