package com.github.nowakprojects.vonage.interview;

import java.util.Objects;

public final class Coordinates {

    private final int x;
    private final int y;

    static Coordinates of(int x, int y) {
        return new Coordinates(x, y);
    }

    private Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    Coordinates xIncreasedBy(int addend) {
        return of(x + addend, y);
    }

    Coordinates xDecreasedBy(int subtrahend) {
        return of(x - subtrahend, y);
    }

    Coordinates yIncreasedBy(int addend) {
        return of(x, y + addend);
    }

    Coordinates yDecreasedBy(int subtrahend) {
        return of(x, y - subtrahend);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
