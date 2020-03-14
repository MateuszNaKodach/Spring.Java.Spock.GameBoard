package com.github.nowakprojects.vonage.interview;

final class TurnLeft implements GameCommand {
    @Override
    public GameBoard apply(GameBoard gameBoard) {
        final PiecePosition oldPosition = gameBoard.piecePosition();
        final PiecePosition newPosition = oldPosition.withDirection(oldPosition.direction().left90degrees());
        return gameBoard.withPiecePosition(newPosition);
    }

    @Override
    public String toString() {
        return "L";
    }
}
