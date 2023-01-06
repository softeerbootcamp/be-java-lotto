package kr.codesquad;

import java.util.List;

public class ManualLottoGeneratorStrategy implements LottoGeneratorStrategy {

	private LottoIOManager lottoIOManager;

	public ManualLottoGeneratorStrategy(LottoIOManager lottoIOManager) {
		this.lottoIOManager = lottoIOManager;
	}

	@Override
	public List<Lotto> generate(int cnt) {
		return lottoIOManager.readManualLotto(cnt);
	}
}
