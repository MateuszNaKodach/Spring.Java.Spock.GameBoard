package com.github.nowakprojects.vonage.interview;

import java.util.Set;

import static com.github.nowakprojects.vonage.interview.GameBoardFixture.aStartingGameBoard;

class RevolutionaryGameFixture {

    static RevolutionaryGame aNewGame() {
        return RevolutionaryGame.newGame();
    }

    static RevolutionaryGame aGameWithPieceOnPosition(PiecePosition piecePosition) {
        return RevolutionaryGame.withBoard(aStartingGameBoard().with(piecePosition));
    }

    static RevolutionaryGame aGameWithPieceOnPositionAndBerries(PiecePosition piecePosition, Set<Coordinates> berries) {
        return RevolutionaryGame.withBoard(aStartingGameBoard().with(piecePosition).with(berries));
    }

    private RevolutionaryGameFixture() {
    }

}
