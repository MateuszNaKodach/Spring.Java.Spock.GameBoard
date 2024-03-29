package com.github.nowakprojects.vonage.interview;

import java.util.Optional;
import java.util.stream.Stream;

public enum PieceDirection {
    NORTH(0),
    EAST(90),
    SOUTH(180),
    WEST(270);

    PieceDirection(int degrees) {
        this.degrees = degrees;
    }

    private final int degrees;

    PieceDirection right90degrees() {
        return findByDegrees(degrees + 90).orElse(PieceDirection.NORTH);
    }

    PieceDirection left90degrees() {
        return findByDegrees(degrees - 90).orElse(PieceDirection.WEST);
    }

    private Optional<PieceDirection> findByDegrees(int degrees) {
        return Stream.of(PieceDirection.values())
                .filter(direction -> direction.degrees == degrees)
                .findFirst();
    }

    @Override
    public String toString() {
        return String.valueOf(name().charAt(0));
    }
}
