package kr.codesquad;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Lotto {

	private final Set<LottoNumber> numbers;

	private Lotto(Set<LottoNumber> lotto) {
		if (lotto.size() != LottoGame.LOTTO_COUNT) {
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
		for (LottoNumber lottoNumber : lotto.numbers) {
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
		Iterator<LottoNumber> iterator = numbers.iterator();
		StringBuilder setStr = new StringBuilder("[");
		while (iterator.hasNext()) {
			setStr.append(iterator.next().toString()).append(", ");
		}
		setStr.delete(setStr.length() - 2, setStr.length());
		setStr.append("]");
		return setStr.toString();
	}
}
