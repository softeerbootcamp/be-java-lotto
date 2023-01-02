package kr.codesquad;

import java.util.Optional;

public enum WinningAmount {

  THREE(3, 5000),
  FOUR(4, 50000),
  FIVE(5, 1500000),
  SIX(6, 2000000000);

  private final int correctCount;
  private final int price;

  WinningAmount(
      int correctCount,
      int price
  ) {
    this.correctCount = correctCount;
    this.price = price;
  }

  public static Optional<WinningAmount> from(int count) {
    WinningAmount result = null;
    switch (count) {
      case 3:
        result = THREE;
        break;
      case 4:
        result = FOUR;
        break;
      case 5:
        result = FIVE;
        break;
      case 6:
        result = SIX;
        break;
    }

    return Optional.ofNullable(result);
  }

  public int getCorrectCount() {
    return correctCount;
  }

  public int getPrice() {
    return price;
  }
}
