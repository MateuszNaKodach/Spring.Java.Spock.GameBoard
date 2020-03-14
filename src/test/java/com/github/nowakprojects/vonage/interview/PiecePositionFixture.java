package com.github.nowakprojects.vonage.interview;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.github.nowakprojects.vonage.interview.PieceDirection.*;
import static com.github.nowakprojects.vonage.interview.PiecePosition.facing;

class PiecePositionFixture {
    static final Coordinates STARTING_POINT = Coordinates.of(0, 0);
    static final Coordinates BOTTOM_LEFT_CORNER = STARTING_POINT;
    static final Coordinates TOP_RIGHT_CORNER = Coordinates.of(4, 4);
    static final Coordinates TOP_LEFT_CORNER = Coordinates.of(0, 4);
    static final Coordinates BOTTOM_RIGHT_CORNER = Coordinates.of(4, 0);

    static final PiecePosition facingNorth = facing(NORTH).on(STARTING_POINT);
    static final PiecePosition facingEast = facing(EAST).on(STARTING_POINT);
    static final PiecePosition facingSouth = facing(SOUTH).on(STARTING_POINT);
    static final PiecePosition facingWest = facing(WEST).on(STARTING_POINT);


    static List<PiecePosition> onLeftEdgeFacing(PieceDirection direction) {
        return IntStream.range(BOTTOM_LEFT_CORNER.y(), TOP_LEFT_CORNER.y() + 1)
                .mapToObj(y -> Coordinates.of(BOTTOM_LEFT_CORNER.x(), y))
                .map(coordinates -> PiecePosition.facing(direction).on(coordinates))
                .collect(Collectors.toList());
    }

    static List<PiecePosition> onRightEdgeFacing(PieceDirection direction) {
        return IntStream.range(BOTTOM_RIGHT_CORNER.y(), TOP_RIGHT_CORNER.y() + 1)
                .mapToObj(y -> Coordinates.of(BOTTOM_RIGHT_CORNER.x(), y))
                .map(coordinates -> PiecePosition.facing(direction).on(coordinates))
                .collect(Collectors.toList());
    }

    static List<PiecePosition> onBottomEdgeFacing(PieceDirection direction) {
        return IntStream.range(BOTTOM_LEFT_CORNER.x(), BOTTOM_RIGHT_CORNER.x() + 1)
                .mapToObj(x -> Coordinates.of(x, BOTTOM_RIGHT_CORNER.y()))
                .map(coordinates -> PiecePosition.facing(direction).on(coordinates))
                .collect(Collectors.toList());
    }

    static List<PiecePosition> onTopEdgeFacing(PieceDirection direction) {
        return IntStream.range(TOP_LEFT_CORNER.x(), TOP_RIGHT_CORNER.x() + 1)
                .mapToObj(x -> Coordinates.of(x, TOP_RIGHT_CORNER.y()))
                .map(coordinates -> PiecePosition.facing(direction).on(coordinates))
                .collect(Collectors.toList());
    }

    private PiecePositionFixture() {
    }
}
