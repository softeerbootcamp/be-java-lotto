package kr.codesquad;

import java.util.Map;

public class LottoGameCreator {
	public static LottoGame createLottoGame() {
		LottoIOManager lottoIOManager = new LottoIOManagerImpl();
		return new LottoGame(new LottoCheckImpl(), lottoIOManager, new LottoGenerator(),
			Map.of("AUTO", new AutoLottoGeneratorStrategy(), "MANUAL",
				new ManualLottoGeneratorStrategy(lottoIOManager)));
	}
}
