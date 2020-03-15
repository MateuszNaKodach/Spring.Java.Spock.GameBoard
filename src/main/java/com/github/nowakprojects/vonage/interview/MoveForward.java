package com.github.nowakprojects.vonage.interview;

import static java.lang.String.format;

public final class MoveForward implements GameCommand {

    @Override
    public GameBoard apply(GameBoard gameBoard) {
        final PiecePosition oldPosition = gameBoard.piecePosition();
        final Coordinates newCoordinates = calculateForwardCoordinates(oldPosition);
        return gameBoard.with(oldPosition.on(newCoordinates));
    }

    private Coordinates calculateForwardCoordinates(PiecePosition oldPosition) {
        final Coordinates oldCoordinates = oldPosition.coordinates();
        final PieceDirection oldDirection = oldPosition.direction();
        switch (oldDirection) {
            case NORTH:
                return oldCoordinates.yIncreasedBy(1);
            case EAST:
                return oldCoordinates.xIncreasedBy(1);
            case SOUTH:
                return oldCoordinates.yDecreasedBy(1);
            case WEST:
                return oldCoordinates.xDecreasedBy(1);
            default:
                throw new IllegalArgumentException(format("Invalid direction (%s)", oldDirection));
        }
    }

    @Override
    public String toString() {
        return "M";
    }
}
