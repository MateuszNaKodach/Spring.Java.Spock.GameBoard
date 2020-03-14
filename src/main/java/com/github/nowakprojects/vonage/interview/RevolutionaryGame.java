package com.github.nowakprojects.vonage.interview;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Objects.nonNull;

public final class RevolutionaryGame {

    private static final PiecePosition STARTING_PIECE_POSITION = PiecePosition.facing(PieceDirection.NORTH).on(Coordinates.of(0, 0));

    private GameBoard gameBoard;

    private RevolutionaryGame(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public static RevolutionaryGame newGame() {
        return RevolutionaryGame.withBoard(GameBoard.with(GameBoardSize.defaultSize(), STARTING_PIECE_POSITION));
    }

    static RevolutionaryGame withBoard(GameBoard gameBoard) {
        return new RevolutionaryGame(gameBoard);
    }

    public final PiecePosition execute(GameCommand command, GameCommand... otherCommands) {
        final Stream<GameCommand> gameCommands = Stream.concat(Stream.of(command), Stream.of(otherCommands));
        return execute(gameCommands);
    }

    public final PiecePosition execute(Stream<GameCommand> commands) {
        return execute(commands.collect(Collectors.toList()));
    }

    public final PiecePosition execute(List<GameCommand> commands) {
        if (nonNull(commands) && !commands.isEmpty()) {
            final GameCommand gameCommands = commands.stream()
                    .reduce(GameCommand::andThen)
                    .get();
            gameBoard = gameCommands.apply(gameBoard);
        }
        return gameBoard.piecePosition();
    }

    final PiecePosition piecePosition() {
        return this.gameBoard.piecePosition();
    }

}
