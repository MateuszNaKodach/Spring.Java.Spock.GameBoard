package com.github.nowakprojects.vonage.interview;

public final class TurnRight implements GameCommand {
    @Override
    public GameBoard apply(GameBoard gameBoard) {
        final PiecePosition oldPosition = gameBoard.piecePosition();
        final PiecePosition newPosition = oldPosition.turned(oldPosition.direction().right90degrees());
        return gameBoard.with(newPosition);
    }

    @Override
    public String toString() {
        return "R";
    }
}
