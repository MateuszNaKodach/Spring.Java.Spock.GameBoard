package com.github.nowakprojects.vonage.interview;

import java.util.Objects;

@FunctionalInterface
public interface GameCommand {

    GameBoard apply(GameBoard board);

    default GameCommand andThen(GameCommand after) {
        Objects.requireNonNull(after);
        return (before) -> after.apply(this.apply(before));
    }
}
