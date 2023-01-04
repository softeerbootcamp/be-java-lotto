package kr.codesquad.domain.winningLotto;

public enum WinningAmount {

  THREE(3, false, 5000),
  FOUR(4, false, 50000),
  FIVE(5, false, 1500000),
  FIVE_WITH_BONUS(5, true, 30000000),
  SIX(6, false, 2000000000);

  private final int correctCount;
  private final boolean bonusMatch;
  private final int price;

  WinningAmount(
      int correctCount,
      boolean bonusMatch,
      int price
  ) {
    this.correctCount = correctCount;
    this.bonusMatch = bonusMatch;
    this.price = price;
  }

  public int getCorrectCount() {
    return correctCount;
  }

  public boolean isBonusMatch() {
    return bonusMatch;
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
