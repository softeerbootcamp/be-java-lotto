package kr.codesquad;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final static int NUMBER_COUNT = 6;

	private Set<LottoNumber> numbers;

	private Lotto(Set<LottoNumber> lotto) {
		if (lotto.size() != NUMBER_COUNT) {
			throw new IllegalArgumentException("로또 숫자 개수가 맞지 않습니다.");
		}
		numbers = lotto;
	}

	public static Lotto of(List<Integer> lotto) {

		Set<LottoNumber> lottoNumberList = new HashSet<>();
		for (int number : lotto) {
			lottoNumberList.add(LottoNumber.of(number));
		}
		return new Lotto(lottoNumberList);
	}

	public int match(Lotto lotto) {
		int match = 0;
		for (LottoNumber lottoNumber : numbers) {
			match += increment(lottoNumber);
		}
		return match;
	}

	public int increment(LottoNumber lottoNumber) {
		if (numbers.contains(lottoNumber)) {
			return 1;
		}
		return 0;
	}

	public String toString() {
		/*
		StringBuilder ret = new StringBuilder();
		ret.append('[');
		for (int i = 0; i < NUMBER_COUNT - 1; i++) {
			ret.append(numbers.);
			ret.append(", ");
		}
		ret.append(numbers.get(NUMBER_COUNT - 1));
		ret.append(']');*/
		return "" + numbers;
	}
}
