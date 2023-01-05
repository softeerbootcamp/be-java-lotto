package kr.codesquad.domain.lotto;

import java.util.Random;

public class RandomNumberFactory {

  private static final Random random = new Random();

  private final int lowerBound;
  private final int upperBound;

  public RandomNumberFactory(
      int lowerBound,
      int upperBound
  ) {
    this.lowerBound = lowerBound;
    this.upperBound = upperBound;
  }

  public int generate() {
    return random.nextInt(upperBound) + lowerBound;
  }

}
