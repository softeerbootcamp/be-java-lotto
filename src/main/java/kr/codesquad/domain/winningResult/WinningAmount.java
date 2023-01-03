package kr.codesquad.domain.winningResult;

public enum WinningAmount {

  THREE(3, 5000),
  FOUR(4, 50000),
  FIVE(5, 1500000),
  FIVE_WITH_BONUS(5, 30000000),
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

  public String toString() {
    return String.format(
        "%d 개 일치"
            + (this.equals(FIVE_WITH_BONUS) ? ", 보너스 볼 일치" : "")
            + " (%d 원)", correctCount, price
    );
  }

}
