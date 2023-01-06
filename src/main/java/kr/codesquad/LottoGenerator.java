package kr.codesquad;

import java.util.List;

public class LottoGenerator {
	private LottoGeneratorStrategy lottoGeneratorStrategy;

	public void LottoGeneratorStrategy(LottoGeneratorStrategy lottoGeneratorStrategy) {
		this.lottoGeneratorStrategy = lottoGeneratorStrategy;
	}

	public void setLottoGeneratorStrategy(LottoGeneratorStrategy lottoGeneratorStrategy) {
		this.lottoGeneratorStrategy = lottoGeneratorStrategy;
	}

	public List<Lotto> generate(int cnt) {
		return lottoGeneratorStrategy.generate(cnt);
	}
}
