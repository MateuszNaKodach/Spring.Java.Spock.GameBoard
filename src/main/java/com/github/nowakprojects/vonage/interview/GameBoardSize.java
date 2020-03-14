package com.github.nowakprojects.vonage.interview;

import java.util.Objects;

import static java.lang.String.format;

final class GameBoardSize {

    private static final int DEFAULT_SIZE = 5;

    private final int raw;

    static GameBoardSize defaultSize() {
        return of(DEFAULT_SIZE);
    }

    static GameBoardSize of(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(format("Game board size (%s) has to be grater than 0", size));
        }
        return new GameBoardSize(size);
    }

    private GameBoardSize(int raw) {
        this.raw = raw;
    }

    public int toInt() {
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
