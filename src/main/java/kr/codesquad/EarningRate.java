package kr.codesquad;

public class EarningRate {

  private final double value;

  public EarningRate(double value) {
    this.value = value;
  }

  public static EarningRate from(double value) {
    return new EarningRate(value);
  }


}
