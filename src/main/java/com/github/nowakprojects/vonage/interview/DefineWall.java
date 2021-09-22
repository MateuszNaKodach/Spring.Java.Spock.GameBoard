package com.github.nowakprojects.vonage.interview;

class DefineWall implements GameCommand {

  private final Coordinates source;
  private final Coordinates target;

  DefineWall(Coordinates source, Coordinates target) {
    this.source = source;
    this.target = target;
  }

  @Override
  public GameBoard apply(GameBoard board) {
    return null;
  }
}
