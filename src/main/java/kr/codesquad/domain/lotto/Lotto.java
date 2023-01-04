package kr.codesquad.domain.lotto;

import java.util.List;

public class Lotto {

  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    this.numbers = numbers;
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  public static Lotto from(List<Integer> numbers) {
    return new Lotto(numbers);
  }

  public String toString() {
    return numbers.toString();
  }

  public boolean isContainNumber(int number) {
    return numbers.contains(number);
  }

}
