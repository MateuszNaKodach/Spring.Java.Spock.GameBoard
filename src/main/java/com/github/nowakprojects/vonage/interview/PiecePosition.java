package com.github.nowakprojects.vonage.interview;

import java.util.Objects;

public final class PiecePosition {

    private final Coordinates coordinates;
    private final PieceDirection direction;

    public static PiecePosition facing(PieceDirection direction) {
        return new PiecePosition(Coordinates.of(0, 0), direction);
    }

    private PiecePosition(Coordinates coordinates, PieceDirection direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public PiecePosition on(Coordinates coordinates) {
        return new PiecePosition(coordinates, this.direction);
    }

    public PiecePosition with(PieceDirection direction) {
        return new PiecePosition(this.coordinates, direction);
    }

    public Coordinates coordinates() {
        return coordinates;
    }

    public PieceDirection direction() {
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
