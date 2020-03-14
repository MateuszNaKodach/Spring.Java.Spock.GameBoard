package com.github.nowakprojects.vonage.interview

import spock.lang.Specification
import spock.lang.Unroll

import static com.github.nowakprojects.vonage.interview.RevolutionaryGameFixture.aGameWithPieceOnPosition
import static com.github.nowakprojects.vonage.interview.RevolutionaryGameFixture.aNewGame
import static com.github.nowakprojects.vonage.interview.GameCommandFixture.M
import static com.github.nowakprojects.vonage.interview.GameCommandFixture.L
import static com.github.nowakprojects.vonage.interview.GameCommandFixture.R
import static com.github.nowakprojects.vonage.interview.PiecePositionFixture.turnedEast
import static com.github.nowakprojects.vonage.interview.PiecePositionFixture.turnedNorth
import static com.github.nowakprojects.vonage.interview.PiecePositionFixture.turnedSouth
import static com.github.nowakprojects.vonage.interview.PiecePositionFixture.turnedWest


class RevolutionaryGameSpec extends Specification {

    @Unroll
    def 'piece position after moves #input should be #output'(input, output) {
        given:
        final game = aNewGame()

        when:
        final piecePosition = game.execute(input)

        then:
        piecePosition == output

        where:
        input                             || output
        [M, R, M, L, M, R, M]             || turnedEast.withCoordinates(Coordinates.of(2, 2))
        [R, M, M, M, L, M, M]             || turnedNorth.withCoordinates(Coordinates.of(3, 2))
        [L, M]                            || turnedWest.withCoordinates(Coordinates.of(0, 0))
        [L, L, M]                         || turnedSouth.withCoordinates(Coordinates.of(0, 0))
        [L, L, L, M]                      || turnedSouth.withCoordinates(Coordinates.of(1, 0))
        [L, L, L, L]                      || turnedSouth.withCoordinates(Coordinates.of(0, 0))
        [R, R, M]                         || turnedSouth.withCoordinates(Coordinates.of(0, 0))
        [R, M, M, M, M, M]                || turnedEast.withCoordinates(Coordinates.of(4, 0))
        [R, M, M, M, M, L, M, M, M, M, M] || turnedNorth.withCoordinates(Coordinates.of(4, 4))
        [M, M, M, M, M]                   || turnedNorth.withCoordinates(Coordinates.of(0, 4))
    }


    @Unroll
    def 'when piece is on #position and try to move forward (off the board), the move should have no effect'(position) {
        given:
        final game = aGameWithPieceOnPosition(position)

        when:
        final piecePosition = game.execute(M)

        then:
        piecePosition == position

        //TODO: Generate pipe with all permutations on the edge
        where:
        position                                          | _
        turnedWest.withCoordinates(Coordinates.of(0, 0))  | _
        turnedSouth.withCoordinates(Coordinates.of(0, 0)) | _
        turnedEast.withCoordinates(Coordinates.of(4, 0))  | _
        turnedSouth.withCoordinates(Coordinates.of(4, 0)) | _
        turnedNorth.withCoordinates(Coordinates.of(0, 4)) | _
        turnedWest.withCoordinates(Coordinates.of(0, 4))  | _
        turnedNorth.withCoordinates(Coordinates.of(4, 4)) | _
        turnedEast.withCoordinates(Coordinates.of(4, 4))  | _
        turnedEast.withCoordinates(Coordinates.of(4, 3))  | _
    }

}
