package model;

import java.util.Objects;

public class Position {
    private Integer standardPosition;
    private Integer targetPosition;

    public Position() {
        this.standardPosition = 0;
        this.targetPosition = null;
    }

    public Position(Integer standardPosition, Integer targetPosition) {
        this.standardPosition = standardPosition;
        this.targetPosition = targetPosition;
    }

    @Override
    public String toString() {
        return "Position{" +
                "standardPosition=" + standardPosition +
                ", targetPosition=" + targetPosition +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(standardPosition, position.standardPosition) && Objects.equals(targetPosition, position.targetPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(standardPosition, targetPosition);
    }

    public Integer getStandardPosition() {
        return standardPosition;
    }

    public void setStandardPosition(Integer standardPosition) {
        this.standardPosition = standardPosition;
    }

    public Integer getTargetPosition() {
        return targetPosition;
    }

    public void setTargetPosition(Integer targetPosition) {
        this.targetPosition = targetPosition;
    }

    public boolean isOnTarget() {
        return targetPosition != null;
    }

    public boolean isOnStart() {
        return standardPosition != null && standardPosition == 0;
    }

    public boolean isOnStandard() {
        return standardPosition != null && standardPosition != 0;
    }

}
