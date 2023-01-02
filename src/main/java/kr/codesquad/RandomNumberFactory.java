package kr.codesquad;

import java.util.Random;

public class RandomNumberFactory {

  private static final Random random = new Random();

  private final int bound;

  public RandomNumberFactory(int bound) {
    this.bound = bound;
  }

  public int generate() {
    return random.nextInt(bound) + 1;
  }

}
