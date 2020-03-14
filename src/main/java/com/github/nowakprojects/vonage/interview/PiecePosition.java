package com.github.nowakprojects.vonage.interview;

import java.util.Objects;

final class PiecePosition {

    private final Coordinates coordinates;
    private final PieceDirection direction;

    static PiecePosition.Builder facing(PieceDirection direction) {
        return new PiecePosition.Builder(direction);
    }

    private PiecePosition(Coordinates coordinates, PieceDirection direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    PiecePosition on(Coordinates coordinates) {
        return new PiecePosition(coordinates, this.direction);
    }

    PiecePosition turned(PieceDirection direction) {
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

    static class Builder {
        private final PieceDirection direction;

        private Builder(PieceDirection direction) {
            this.direction = direction;
        }

        PiecePosition on(Coordinates coordinates) {
            return new PiecePosition(coordinates, this.direction);
        }
    }
}
