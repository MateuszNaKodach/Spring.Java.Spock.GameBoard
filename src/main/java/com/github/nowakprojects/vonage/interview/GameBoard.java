package com.github.nowakprojects.vonage.interview;

public final class GameBoard {

    private final GameBoardSize size;
    private final PiecePosition piecePosition;

    static GameBoard with(GameBoardSize size, PiecePosition piecePosition) {
        return new GameBoard(size, piecePosition);
    }

    private GameBoard(GameBoardSize size, PiecePosition piecePosition) {
        this.size = size;
        this.piecePosition = piecePosition;
    }

    GameBoardSize size() {
        return size;
    }

    public PiecePosition piecePosition() {
        return piecePosition;
    }

    public GameBoard with(PiecePosition piecePosition) {
        final Coordinates newPieceCoordinates = piecePosition.coordinates();
        return isOffTheBoard(newPieceCoordinates)
                ? this
                : new GameBoard(this.size, piecePosition);
    }

    private boolean isOffTheBoard(Coordinates coordinates) {
        return coordinates.x() >= size.toInt()
                || coordinates.y() >= size.toInt()
                || coordinates.x() < 0
                || coordinates.y() < 0;
    }
}
