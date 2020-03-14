package com.github.nowakprojects.vonage.interview;

class GameBoardFixture {

    static GameBoard aStartingGameBoard() {
        return GameBoard.with(GameBoardSize.defaultSize(), PiecePosition.facing(PieceDirection.NORTH).on(Coordinates.of(0, 0)));
    }

    private GameBoardFixture() {
    }
}
