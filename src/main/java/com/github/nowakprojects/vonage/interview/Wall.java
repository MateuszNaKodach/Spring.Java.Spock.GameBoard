package com.github.nowakprojects.vonage.interview;

import java.util.Objects;

class Wall {

  private final Coordinates source;
  private final Coordinates target;

  Wall(Coordinates source, Coordinates target) {
    this.source = source;
    this.target = target;
  }

  Coordinates source() {
    return source;
  }

  Coordinates target() {
    return target;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Wall)) return false;
    Wall wall = (Wall) o;
    return source.equals(wall.source) && target.equals(wall.target);
  }

  @Override
  public int hashCode() {
    return Objects.hash(source, target);
  }
}
