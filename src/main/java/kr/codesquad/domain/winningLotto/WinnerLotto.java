package kr.codesquad.domain.winningLotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import kr.codesquad.domain.lotto.Lotto;

public class WinnerLotto {

  private final Lotto lotto;
  private final int bonusNumber;

  public WinnerLotto(
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

  public Optional<Rank> check(Lotto target) {
    return Arrays.stream(Rank.values())
                 .filter(rank -> countMatch(target) == rank.getCorrectCount())
                 .filter(rank -> isBonusMatch(target) == rank.isBonusMatch())
                 .findFirst();
  }

}
