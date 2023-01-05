package kr.codesquad;

import java.util.List;
import java.util.Map;

public class LottoGame {

	private final LottoIOManager lottoIOManager;

	private final Map<String, LottoGeneratorStrategy> lottoGeneratorStrategies;

	private final LottoGenerator lottoGenerator;

	public final static int LOTTO_PRICE = 1000;

	public final static int LOTTO_COUNT = 6;

	public LottoGame(LottoIOManager lottoIOManager, LottoGenerator lottoGenerator,
		Map<String, LottoGeneratorStrategy> lottoGeneratorStrategies) {
		this.lottoGeneratorStrategies = lottoGeneratorStrategies;
		this.lottoIOManager = lottoIOManager;
		this.lottoGenerator = lottoGenerator;
	}

	public void compareEachLotto(Lotto purchasedLotto, WinningLotto winningLotto, LottoResult lottoResult) {
		LottoMatchType lottoMatchType = winningLotto.matchLotto(purchasedLotto);
		lottoResult.updateResult(lottoMatchType.getMatchCount(), 1);
	}

	public LottoResult checkMyLotto(List<Lotto> purchasedLottoList, WinningLotto winningLotto) {
		LottoResult lottoResult = new LottoResult();
		for (Lotto lotto : purchasedLottoList) {
			compareEachLotto(lotto, winningLotto, lottoResult);
		}

		return lottoResult;
	}

	public List<Lotto> buy() {
		// 금액 입력받기
		int purchaseAmount = lottoIOManager.readPurchaseAmount();
		// 수동 개수 입력
		int manualLottoCount = lottoIOManager.readManualLottoCount();
		// 자동 개수
		int autoLottoCount = purchaseAmount / LOTTO_PRICE - manualLottoCount;
		// 로또 발급
		List<Lotto> lottos = generateLottos(manualLottoCount, autoLottoCount);
		// 발급 결과 출력
		printLottosInfo(manualLottoCount, autoLottoCount, lottos);

		return lottos;
	}

	public void printLottosInfo(int manualLottoCount, int autoLottoCount, List<Lotto> lottos) {
		lottoIOManager.printLottoCount(manualLottoCount, autoLottoCount);
		lottoIOManager.printLottos(lottos);
	}

	public List<Lotto> generateLottos(int manualLottoCount, int autoLottoCount) {
		lottoGenerator.setLottoGeneratorStrategy(lottoGeneratorStrategies.get("MANUAL"));
		List<Lotto> lottos = lottoGenerator.generate(manualLottoCount);
		// 자동
		lottoGenerator.setLottoGeneratorStrategy(lottoGeneratorStrategies.get("AUTO"));
		lottos.addAll(lottoGenerator.generate(autoLottoCount));
		return lottos;
	}

	public WinningLotto createWinningLottery() {
		return lottoIOManager.readWinningLotto();
	}

	public void printLottoResult(LottoResult lottoResult, int lottoCount) {
		lottoIOManager.printResult(lottoResult, lottoCount * LOTTO_PRICE);
	}

}
