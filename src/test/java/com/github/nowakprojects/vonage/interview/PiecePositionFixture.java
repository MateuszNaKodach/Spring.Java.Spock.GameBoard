package com.github.nowakprojects.vonage.interview;

import static com.github.nowakprojects.vonage.interview.PieceDirection.*;
import static com.github.nowakprojects.vonage.interview.PiecePosition.turned;

class PiecePositionFixture {
    static PiecePosition turnedNorth = turned(NORTH);
    static PiecePosition turnedEast = turned(EAST);
    static PiecePosition turnedSouth = turned(SOUTH);
    static PiecePosition turnedWest = turned(WEST);
}
