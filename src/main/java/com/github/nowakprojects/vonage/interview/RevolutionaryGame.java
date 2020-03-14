package com.github.nowakprojects.vonage.interview;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

final class RevolutionaryGame {

    private GameBoard gameBoard;

    static RevolutionaryGame withBoard(GameBoard gameBoard) {
        return new RevolutionaryGame(gameBoard);
    }

    private RevolutionaryGame(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    @SafeVarargs
    final PiecePosition execute(Function<GameBoard, GameBoard> command, Function<GameBoard, GameBoard>... otherCommands) {
        final Function<GameBoard,GameBoard> gameCommands = Stream.of(otherCommands)
                .reduce(command, Function::andThen);
        gameBoard = gameCommands.apply(gameBoard);
        return gameBoard.piecePosition();
    }

    PiecePosition execute(List<Function<GameBoard,GameBoard>> commands) {
        if (commands.isEmpty()) {
            return gameBoard.piecePosition();
        } else {
            final Function<GameBoard,GameBoard> firstCommand = commands.get(0);
            final GameCommand[] otherCommands = commands.subList(1, commands.size()).toArray(GameCommand[]::new);
            return execute(firstCommand, otherCommands);
        }
    }

}
