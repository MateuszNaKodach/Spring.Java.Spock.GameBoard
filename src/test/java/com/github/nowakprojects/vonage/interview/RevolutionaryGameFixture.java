package com.github.nowakprojects.vonage.interview;

import static com.github.nowakprojects.vonage.interview.GameBoardFixture.startingGameBoard;

class RevolutionaryGameFixture {

    static RevolutionaryGame aNewGame() {
        return RevolutionaryGame.withBoard(startingGameBoard());
    }

    static RevolutionaryGame aGameWithPieceOnPosition(PiecePosition piecePosition) {
        return RevolutionaryGame.withBoard(startingGameBoard().withPiecePosition(piecePosition));
    }

}
