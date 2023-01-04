package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoGenerator implements LottoGenerator {
	private final int LOTTO_NUMBER_COUNT = 6;

	public List<Integer> lottoNumberList;

	public AutoLottoGenerator() {
		lottoNumberList = new ArrayList<>();
		for (int i = 1; i <= 45; i++) {
			lottoNumberList.add(i);
		}
	}

	public Lotto getNewLotto() {
		Collections.shuffle(lottoNumberList);
		List<Integer> newLottoNumbers = new ArrayList<>(lottoNumberList.subList(0, LOTTO_NUMBER_COUNT));
		Collections.sort(newLottoNumbers);

		return Lotto.of(newLottoNumbers);
	}

	@Override
	public List<Lotto> generate(int lottoCount) {
		List<Lotto> lottoList = new ArrayList<Lotto>();
		for (int i = 0; i < lottoCount; i++) {
			lottoList.add(getNewLotto());
		}

		return lottoList;
	}
}
