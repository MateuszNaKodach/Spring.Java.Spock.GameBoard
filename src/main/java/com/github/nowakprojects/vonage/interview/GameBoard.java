package com.github.nowakprojects.vonage.interview;

//TODO: Remove size or check size boundary while moving in tests
final class GameBoard {

    private final GameBoardSize size;
    private final PiecePosition piecePosition;

    static GameBoard withSize(GameBoardSize size) {
        return new GameBoard(size);
    }

    private GameBoard(GameBoardSize size) {
        this.size = size;
        this.piecePosition = new PiecePosition(Coordinates.of(0, 0), PieceDirection.NORTH);
    }

    private GameBoard(GameBoardSize size, PiecePosition piecePosition) {
        this.size = size;
        this.piecePosition = piecePosition;
    }

    GameBoardSize size() {
        return size;
    }

    PiecePosition piecePosition() {
        return piecePosition;
    }

    GameBoard withPiecePosition(PiecePosition piecePosition) {
        final Coordinates newPieceCoordinates = piecePosition.coordinates();
        return newPieceCoordinates.x() >= size.toInt() || newPieceCoordinates.y() >= size.toInt() || newPieceCoordinates.x() < 0 || newPieceCoordinates.y() < 0
                ? this
                : new GameBoard(this.size, piecePosition);
    }
}
