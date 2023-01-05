package kr.codesquad.domain.lotto;

import java.util.HashSet;
import java.util.List;

import kr.codesquad.common.utils.NumberListUtil;

public class Lotto {

  public static final int LOTTO_NUMBER_UPPER_BOUND = 45;
  public static final int LOTTO_NUMBER_LOWER_BOUND = 1;
  public static final int LOTTO_NUMBER_COUNT = 6;

  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  private void validate(List<Integer> numbers) {
    int max = NumberListUtil.max(numbers);
    int min = NumberListUtil.min(numbers);
    int size = new HashSet<>(numbers).size();

    if (LOTTO_NUMBER_UPPER_BOUND < max || min < LOTTO_NUMBER_LOWER_BOUND || LOTTO_NUMBER_COUNT != size) {
      throw new IllegalArgumentException("잘못된 로또 번호 형식 입니다");
    }
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
