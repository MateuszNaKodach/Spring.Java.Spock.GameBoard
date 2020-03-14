package com.github.nowakprojects.vonage.interview

import spock.lang.Specification

import static com.github.nowakprojects.vonage.interview.GameBoardFixture.anyGameBoard

class GameBoardSpec extends Specification {

    def 'game board has a fixed size of 5 squares'() {
        given:
        final gameBoard = anyGameBoard()

        expect:
        gameBoard.size() == GameBoardSize.of(5)
    }

}
