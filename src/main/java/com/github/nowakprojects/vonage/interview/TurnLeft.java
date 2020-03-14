package com.github.nowakprojects.vonage.interview;

public final class TurnLeft implements GameCommand {
    @Override
    public GameBoard apply(GameBoard gameBoard) {
        final PiecePosition oldPosition = gameBoard.piecePosition();
        final PiecePosition newPosition = oldPosition.turned(oldPosition.direction().left90degrees());
        return gameBoard.with(newPosition);
    }

    @Override
    public String toString() {
        return "L";
    }
}
