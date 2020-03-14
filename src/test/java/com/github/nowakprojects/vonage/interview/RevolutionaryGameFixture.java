package com.github.nowakprojects.vonage.interview;

import static com.github.nowakprojects.vonage.interview.GameBoardFixture.aStartingGameBoard;

class RevolutionaryGameFixture {

    static RevolutionaryGame aNewGame() {
        return RevolutionaryGame.newGame();
    }

    static RevolutionaryGame aGameWithPieceOnPosition(PiecePosition piecePosition) {
        return RevolutionaryGame.withBoard(aStartingGameBoard().with(piecePosition));
    }

    private RevolutionaryGameFixture() {
    }

}
