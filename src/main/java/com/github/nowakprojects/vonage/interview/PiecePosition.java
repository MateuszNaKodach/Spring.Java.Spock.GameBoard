package com.github.nowakprojects.vonage.interview;

import java.util.Objects;

public final class PiecePosition {

    private final Coordinates coordinates;
    private final PieceDirection direction;
    private final int collectedBerries;

    static PiecePosition.Builder facing(PieceDirection direction) {
        return new PiecePosition.Builder(direction);
    }

    private PiecePosition(Coordinates coordinates, PieceDirection direction, int collectedBerries) {
        this.coordinates = coordinates;
        this.direction = direction;
        this.collectedBerries = collectedBerries;
    }

    PiecePosition on(Coordinates coordinates) {
        return new PiecePosition(coordinates, this.direction, this.collectedBerries);
    }

    PiecePosition turned(PieceDirection direction) {
        return new PiecePosition(this.coordinates, direction, this.collectedBerries);
    }

    PiecePosition collectBerry() {
        return new PiecePosition(this.coordinates, direction, this.collectedBerries + 1);
    }

    int collectedBerries(){
        return collectedBerries;
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
        return coordinates + " " + direction;
    }

    static class Builder {
        private final PieceDirection direction;

        private Builder(PieceDirection direction) {
            this.direction = direction;
        }

        PiecePosition on(Coordinates coordinates) {
            return new PiecePosition(coordinates, this.direction, 0);
        }
    }
}
