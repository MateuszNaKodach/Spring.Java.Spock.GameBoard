package com.github.nowakprojects.vonage.interview;

class TurnRight implements GameCommand {
    @Override
    public GameBoard apply(GameBoard gameBoard) {
        final PiecePosition oldPosition = gameBoard.piecePosition();
        final PiecePosition newPosition = oldPosition.withDirection(oldPosition.direction().right90degrees());
        return gameBoard.withPiecePosition(newPosition);
    }

    @Override
    public String toString() {
        return "R";
    }
}
