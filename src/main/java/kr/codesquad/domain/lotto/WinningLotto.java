package kr.codesquad.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {

  private final Lotto lotto;
  private final int bonusNumber;

  public WinningLotto(
      Lotto lotto,
      int bonusNumber
  ) {
    this.lotto = lotto;
    this.bonusNumber = bonusNumber;
  }

  public int countMatch(Lotto target) {
    Set<Integer> set = new HashSet<>(target.getNumbers());
    List<Integer> winnerNumbers = lotto.getNumbers();
    return (int)winnerNumbers.stream()
                             .filter(set::contains)
                             .count();
  }

  public boolean isBonusMatch(Lotto target) {
    return target.isContainNumber(this.bonusNumber);
  }

}
