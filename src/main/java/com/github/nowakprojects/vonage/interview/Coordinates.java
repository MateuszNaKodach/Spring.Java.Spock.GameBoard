package com.github.nowakprojects.vonage.interview;

import java.util.Objects;

final class Coordinates {

    private final int x;
    private final int y;

    static Coordinates of(int x, int y) {
        return new Coordinates(x, y);
    }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public Coordinates increaseXBy(int addend) {
        return of(x + addend, y);
    }

    public Coordinates decreaseXBy(int subtrahend) {
        return of(x - subtrahend, y);
    }

    public Coordinates increaseYBy(int addend) {
        return of(x, y + addend);
    }

    public Coordinates decreaseYBy(int subtrahend) {
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
