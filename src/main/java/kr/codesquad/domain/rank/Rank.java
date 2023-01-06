package kr.codesquad.domain.rank;

public enum Rank {

  FIRST(6, false, 2000000000),
  SECOND(5, true, 30000000),
  THIRD(5, false, 1500000),
  FOURTH(4, false, 50000),
  FIFTH(3, false, 5000);

  private final int correctCount;
  private final boolean bonusMatch;
  private final int price;

  Rank(
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
            + (this.equals(SECOND) ? ", 보너스 볼 일치" : "")
            + " (%d 원)", correctCount, price
    );
  }

}
