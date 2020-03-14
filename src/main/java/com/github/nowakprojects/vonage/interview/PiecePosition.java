package com.github.nowakprojects.vonage.interview;

import java.util.Objects;

class PiecePosition {

    private final Coordinates coordinates;
    private final PieceDirection direction;

    PiecePosition(Coordinates coordinates, PieceDirection direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    static PiecePosition turned(PieceDirection direction) {
        return new PiecePosition(Coordinates.of(0, 0), direction);
    }

    PiecePosition withCoordinates(Coordinates coordinates) {
        return new PiecePosition(coordinates, this.direction);
    }

    PiecePosition withDirection(PieceDirection direction) {
        return new PiecePosition(this.coordinates, direction);
    }

    Coordinates coordinates() {
        return coordinates;
    }

    PieceDirection direction() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PiecePosition that = (PiecePosition) o;
        return coordinates.equals(that.coordinates) &&
                direction == that.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates, direction);
    }

    @Override
    public String toString() {
        return coordinates + " " + direction.name().charAt(0);
    }
}
