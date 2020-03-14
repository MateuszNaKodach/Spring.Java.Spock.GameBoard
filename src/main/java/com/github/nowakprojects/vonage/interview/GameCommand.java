package com.github.nowakprojects.vonage.interview;

import java.util.function.Function;

@FunctionalInterface
interface GameCommand extends Function<GameBoard, GameBoard> {
}
