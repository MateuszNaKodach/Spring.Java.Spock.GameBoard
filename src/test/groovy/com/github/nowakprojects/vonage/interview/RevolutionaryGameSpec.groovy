package com.github.nowakprojects.vonage.interview

import spock.lang.Specification
import spock.lang.Unroll

import static com.github.nowakprojects.vonage.interview.PieceDirection.*
import static com.github.nowakprojects.vonage.interview.PiecePositionFixture.facingSouth
import static com.github.nowakprojects.vonage.interview.PiecePositionFixture.onBottomEdgeFacing
import static com.github.nowakprojects.vonage.interview.PiecePositionFixture.onLeftEdgeFacing
import static com.github.nowakprojects.vonage.interview.PiecePositionFixture.onRightEdgeFacing
import static com.github.nowakprojects.vonage.interview.PiecePositionFixture.onTopEdgeFacing
import static com.github.nowakprojects.vonage.interview.RevolutionaryGameFixture.aGameWithPieceOnPosition
import static com.github.nowakprojects.vonage.interview.RevolutionaryGameFixture.aNewGame
import static com.github.nowakprojects.vonage.interview.GameCommandFixture.M
import static com.github.nowakprojects.vonage.interview.GameCommandFixture.L
import static com.github.nowakprojects.vonage.interview.GameCommandFixture.R
import static com.github.nowakprojects.vonage.interview.PiecePositionFixture.facingEast
import static com.github.nowakprojects.vonage.interview.PiecePositionFixture.facingNorth
import static com.github.nowakprojects.vonage.interview.PiecePositionFixture.facingWest
import static com.github.nowakprojects.vonage.interview.PiecePositionFixture.STARTING_POINT
import static com.github.nowakprojects.vonage.interview.PiecePositionFixture.TOP_RIGHT_CORNER


class RevolutionaryGameSpec extends Specification {

    def 'the piece will start in the bottom left corner of the board facing North'() {
        given:
        final game = aNewGame()

        expect:
        game.piecePosition() == facingNorth.on(STARTING_POINT)
    }

    @Unroll
    def 'piece position after moves #input should be #output'(List<GameCommand> input, PiecePosition output) {
        given:
        final game = aNewGame()

        when:
        final piecePosition = game.execute(input)

        then:
        piecePosition == output

        where:
        input                                || output
        []                                   || facingNorth.on(STARTING_POINT)
        [L]                                  || facingWest.on(STARTING_POINT)
        [R]                                  || facingEast.on(STARTING_POINT)
        [M]                                  || facingNorth.on(Coordinates.of(0, 1))
        [L, L, L, M]                         || facingEast.on(Coordinates.of(1, 0))
        [L, L, L, L]                         || facingNorth.on(STARTING_POINT)
        [M, R, M, L, M, R, M]                || facingEast.on(Coordinates.of(2, 2))
        [R, M, M, M, L, M, M]                || facingNorth.on(Coordinates.of(3, 2))
        [R, M, M, M, M, L, M, M, M, M]       || facingNorth.on(TOP_RIGHT_CORNER)
        [M, M, M, M, M, L, L, M, M, M, M, M] || facingSouth.on(STARTING_POINT)
    }


    @Unroll
    def 'when piece is on edge position #position and try to move forward (off the board), the move should have no effect'(PiecePosition position) {
        given:
        final game = aGameWithPieceOnPosition(position)

        when:
        final piecePosition = game.execute(M)

        then:
        piecePosition == position

        where:
        position << onLeftEdgeFacing(WEST) + onRightEdgeFacing(EAST) + onBottomEdgeFacing(SOUTH) + onTopEdgeFacing(NORTH)
    }

}
