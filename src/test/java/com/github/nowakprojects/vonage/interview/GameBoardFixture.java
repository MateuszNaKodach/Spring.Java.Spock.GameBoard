package com.github.nowakprojects.vonage.interview;

class GameBoardFixture {

    static GameBoard anyGameBoard() {
        return GameBoard.withSize(GameBoardSize.defaultSize());
    }

    static GameBoard startingGameBoard() {
        return GameBoard.withSize(GameBoardSize.defaultSize());
    }

}
