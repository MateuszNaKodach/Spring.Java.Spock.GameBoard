package com.github.nowakprojects.vonage.interview;

import java.util.Collections;
import java.util.Set;

final class GameBoard {

    private final GameBoardSize size;
    private final PiecePosition piecePosition;
    private final Set<Wall> walls;

    static GameBoard with(GameBoardSize size, PiecePosition piecePosition) {
        return new GameBoard(size, piecePosition, Collections.emptySet());
    }

    private GameBoard(GameBoardSize size, PiecePosition piecePosition, Set<Wall> walls) {
        this.size = size;
        this.piecePosition = piecePosition;
        this.walls = walls != null ? walls : Collections.emptySet();
    }

    GameBoardSize size() {
        return size;
    }

    PiecePosition piecePosition() {
        return piecePosition;
    }

    GameBoard with(PiecePosition piecePosition) {
        final Coordinates newPieceCoordinates = piecePosition.coordinates();
        return isOffTheBoard(newPieceCoordinates)
                ? this
                : new GameBoard(this.size, piecePosition, walls);
    }

    GameBoard with(Wall wall){
        return new GameBoard()
    }

    private boolean isOffTheBoard(Coordinates coordinates) {
        return coordinates.x() >= size.toInt()
                || coordinates.y() >= size.toInt()
                || coordinates.x() < 0
                || coordinates.y() < 0;
    }
}
