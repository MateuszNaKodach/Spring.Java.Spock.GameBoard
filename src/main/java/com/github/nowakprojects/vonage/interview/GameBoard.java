package com.github.nowakprojects.vonage.interview;

/*
Jagódki na mapie - podczas tworzenia
Pionek chodzi po mapie

 */

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

final class GameBoard {

    private final GameBoardSize size;
    private final PiecePosition piecePosition;
    private final Set<Coordinates> berries;

    static GameBoard with(GameBoardSize size, PiecePosition piecePosition) {
        return new GameBoard(size, piecePosition, Collections.emptySet());
    }

    static GameBoard with(GameBoardSize size, PiecePosition piecePosition, Set<Coordinates> berries) {
        return new GameBoard(size, piecePosition, berries);
    }

    private GameBoard(GameBoardSize size, PiecePosition piecePosition, Set<Coordinates> berries) {
        this.size = size;
        this.piecePosition = piecePosition;
        this.berries = berries;
    }

    GameBoardSize size() {
        return size;
    }

    GameBoard with(Set<Coordinates> berries) {
        return new GameBoard(this.size, piecePosition, berries);
    }

    PiecePosition piecePosition() {
        return piecePosition;
    }

    boolean isBerryOn(Coordinates coordinates) {
        return berries.contains(coordinates);
    }

    GameBoard with(PiecePosition piecePosition) {
        final Coordinates newPieceCoordinates = piecePosition.coordinates();
        boolean berryOnNewCoordinates = isBerryOn(newPieceCoordinates);
        PiecePosition newPiecePosition = berryOnNewCoordinates ? piecePosition.collectBerry() : piecePosition;
        final Set<Coordinates> berriesAfterMove = !berryOnNewCoordinates ? berries : berries.stream()
                .filter(berryCoordinates -> !berryCoordinates.equals(newPieceCoordinates))
                .collect(Collectors.toSet());
        return isOffTheBoard(newPieceCoordinates)
                ? this
                : new GameBoard(this.size, newPiecePosition, berriesAfterMove);
    }

    private boolean isOffTheBoard(Coordinates coordinates) {
        return coordinates.x() >= size.toInt()
                || coordinates.y() >= size.toInt()
                || coordinates.x() < 0
                || coordinates.y() < 0;
    }
}
