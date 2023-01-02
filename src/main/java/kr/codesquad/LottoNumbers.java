package kr.codesquad;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {

  private final List<Integer> numbers;

  public LottoNumbers(List<Integer> numbers) {
    this.numbers = numbers;
  }

  public static LottoNumbers from(List<Integer> numbers) {
    return new LottoNumbers(numbers);
  }

  public String toString() {
    return numbers.toString();
  }

  public int countMatch(LottoNumbers target) {
    Set<Integer> set = new HashSet<>(target.numbers);
    return (int)this.numbers.stream()
                            .filter(set::contains)
                            .count();
  }

}
