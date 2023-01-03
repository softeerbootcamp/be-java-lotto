package kr.codesquad.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    this.numbers = numbers;
  }

  public static Lotto from(List<Integer> numbers) {
    return new Lotto(numbers);
  }

  public String toString() {
    return numbers.toString();
  }

  public int countMatch(Lotto target) {
    Set<Integer> set = new HashSet<>(target.numbers);
    return (int)this.numbers.stream()
                            .filter(set::contains)
                            .count();
  }

  public boolean isContainNumber(int number) {
    return numbers.contains(number);
  }

}
