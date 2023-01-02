package kr.codesquad.domain.earningRate;

public class EarningRate {

  private final double value;

  public EarningRate(double value) {
    this.value = value;
  }

  public static EarningRate of(
      long totalWinningMoney,
      int purchaseAmount
  ) {
    double rate = ((double)(totalWinningMoney - purchaseAmount) / (double)purchaseAmount) * 100;
    return new EarningRate(rate);
  }

  @Override
  public String toString() {
    return String.format("%.2f%%", value);
  }

}
