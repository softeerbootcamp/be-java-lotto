package kr.codesquad.domain.lotto;

import java.util.List;

public class WinningLotto extends Lotto {

  private final int bonusNumber;

  public WinningLotto(
      List<Integer> numbers,
      int bonusNumber
  ) {
    super(numbers);
    this.bonusNumber = bonusNumber;
  }

  public static WinningLotto of(
      List<Integer> numbers,
      int bonusNumber
  ) {
    return new WinningLotto(numbers, bonusNumber);
  }

  public boolean isBonusMatch(Lotto target) {
    return target.isContainNumber(this.bonusNumber);
  }

}
