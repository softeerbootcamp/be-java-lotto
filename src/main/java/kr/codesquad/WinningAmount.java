package kr.codesquad;

public enum WinningAmount {

  THREE(3, 5000),
  FOUR(4, 50000),
  FIVE(5, 1500000),
  SIX(6, 2000000000);

  private final int correctCount;
  private final double price;

  WinningAmount(
      int correctCount,
      double price
  ) {
    this.correctCount = correctCount;
    this.price = price;
  }

  public int getCorrectCount() {
    return correctCount;
  }

  public double getPrice() {
    return price;
  }
}
