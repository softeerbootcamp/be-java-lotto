package kr.codesquad.domain.winningResult;

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

  public int getPrice() {
    return price;
  }
}
