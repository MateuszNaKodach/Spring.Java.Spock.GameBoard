package com.github.nowakprojects.vonage.interview;

import static java.lang.String.format;

final class MoveForward implements GameCommand {

    @Override
    public GameBoard apply(GameBoard gameBoard) {
        final PiecePosition oldPosition = gameBoard.piecePosition();
        final Coordinates newCoordinates = calculateCoordinates(oldPosition);
        return gameBoard.with(oldPosition.on(newCoordinates));
    }

    private Coordinates calculateCoordinates(PiecePosition oldPosition) {
        final Coordinates oldCoordinates = oldPosition.coordinates();
        final PieceDirection oldDirection = oldPosition.direction();
        switch (oldDirection) {
            case NORTH:
                return oldCoordinates.increaseYBy(1);
            case EAST:
                return oldCoordinates.increaseXBy(1);
            case SOUTH:
                return oldCoordinates.decreaseYBy(1);
            case WEST:
                return oldCoordinates.decreaseXBy(1);
            default:
                throw new IllegalArgumentException(format("Invalid direction (%s)", oldDirection));
        }
    }

    @Override
    public String toString() {
        return "M";
    }
}
