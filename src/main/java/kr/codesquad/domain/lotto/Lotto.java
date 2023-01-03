package kr.codesquad.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

  private final List<Integer> numbers;
  private final int bonusNumber;

  public Lotto(
      List<Integer> numbers,
      int bonusNumber
  ) {
    this.numbers = numbers;
    this.bonusNumber = bonusNumber;
  }

  public static Lotto of(
      List<Integer> numbers,
      int bonusNumber
  ) {
    return new Lotto(numbers, bonusNumber);
  }

  public String toString() {
    return numbers.toString() + String.format("\t\t보너스 번호 [%d]", bonusNumber);
  }

  public int countMatch(Lotto target) {
    Set<Integer> set = new HashSet<>(target.numbers);
    return (int)this.numbers.stream()
                            .filter(set::contains)
                            .count();
  }

  public boolean isBonusMatch(Lotto target) {
    return this.bonusNumber == target.bonusNumber;
  }

}
