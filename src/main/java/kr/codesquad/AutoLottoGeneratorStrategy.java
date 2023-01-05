package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoGeneratorStrategy implements LottoGeneratorStrategy {

	private static final List<Integer> lottoNumbers;

	static {
		lottoNumbers = new ArrayList<>();
		for (int i = 1; i <= 45; i++) {
			lottoNumbers.add(i);
		}
	}

	@Override
	public List<Lotto> generate(int cnt) {
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < cnt; i++) {
			lottos.add(newLotto());
		}

		return lottos;
	}

	private Lotto newLotto() {
		Collections.shuffle(lottoNumbers);
		List<Integer> newLottoNumbers = new ArrayList<>(lottoNumbers.subList(0, LOTTO_NUMBER_COUNT));
		return Lotto.of(newLottoNumbers);
	}
}
