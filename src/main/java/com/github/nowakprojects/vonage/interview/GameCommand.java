package com.github.nowakprojects.vonage.interview;

import java.util.Objects;

@FunctionalInterface
public interface GameCommand {

    GameBoard apply(GameBoard board);

    default GameCommand andThen(GameCommand nextCommand) {
        Objects.requireNonNull(nextCommand);
        return (gameBoard) -> nextCommand.apply(this.apply(gameBoard));
    }
}
