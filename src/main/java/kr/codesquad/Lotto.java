package kr.codesquad;

import java.util.List;

public class Lotto {
	private final static int NUMBER_COUNT = 6;

	private List<Integer> numbers;

	private Lotto(List<Integer> lotto) {
		numbers = lotto;
	}

	public static Lotto of(List<Integer> lotto) {
		return new Lotto(lotto);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public int getNumbersSize() {
		return numbers.size();
	}

	public String toString() {

		StringBuilder ret = new StringBuilder();
		ret.append('[');
		for (int i = 0; i < NUMBER_COUNT - 1; i++) {
			ret.append(numbers.get(i));
			ret.append(", ");
		}
		ret.append(numbers.get(NUMBER_COUNT - 1));
		ret.append(']');
		return ret.toString();
	}
}
