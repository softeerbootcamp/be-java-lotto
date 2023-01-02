package kr.codesquad;

import java.util.List;

public class LottoNumbers {

  private final List<Integer> numbers;

  public LottoNumbers(List<Integer> numbers) {
    this.numbers = numbers;
  }

  public static LottoNumbers from(List<Integer> numbers) {
    return new LottoNumbers(numbers);
  }

}
