package com.github.nowakprojects.vonage.interview;

import java.util.Objects;

import static java.lang.String.format;

final class GameBoardSize {

    private static final int DEFAULT_SIZE = 5;

    private final int raw;

    static GameBoardSize defaultSize() {
        return squareWithSideLength(DEFAULT_SIZE);
    }

    private static GameBoardSize squareWithSideLength(int sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException(format("Game board side length (%s) is invalid. The length has to be greater than 0", sideLength));
        }
        return new GameBoardSize(sideLength);
    }

    private GameBoardSize(int raw) {
        this.raw = raw;
    }

    int toInt() {
        return raw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameBoardSize that = (GameBoardSize) o;
        return raw == that.raw;
    }

    @Override
    public int hashCode() {
        return Objects.hash(raw);
    }
}
