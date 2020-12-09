package com.github.nowakprojects.vonage.interview

import spock.lang.Specification

import static com.github.nowakprojects.vonage.interview.GameBoardFixture.aStartingGameBoard

class GameBoardSpec extends Specification {

    def 'game board has a fixed size of 5 squares'() {
        given:
        final gameBoard = aStartingGameBoard()

        expect:
        gameBoard.size().toInt() == 5
    }

    def 'game board has placed set of berries'(){

    }

}
