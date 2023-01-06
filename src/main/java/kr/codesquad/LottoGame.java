package kr.codesquad;

import java.util.List;
import java.util.Map;

public class LottoGame {

	public final static int LOTTO_PRICE = 1000;

	public final static int LOTTO_COUNT = 6;

	private final LottoIOManager lottoIOManager;

	private final Map<String, LottoGeneratorStrategy> lottoGeneratorStrategies;

	private final LottoGenerator lottoGenerator;

	private final LottoCheck lottoCheck;

	public LottoGame(
		LottoCheck lottoCheck,
		LottoIOManager lottoIOManager,
		LottoGenerator lottoGenerator,
		Map<String, LottoGeneratorStrategy> lottoGeneratorStrategies
	) {
		this.lottoCheck = lottoCheck;
		this.lottoGeneratorStrategies = lottoGeneratorStrategies;
		this.lottoIOManager = lottoIOManager;
		this.lottoGenerator = lottoGenerator;
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

	public LottoResult checkLotto(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
		return lottoCheck.checkLotto(purchasedLottos, winningLotto);
	}

	public void printLottosInfo(int manualLottoCount, int autoLottoCount, List<Lotto> lottos) {
		lottoIOManager.printLottoCount(manualLottoCount, autoLottoCount);
		lottoIOManager.printLottos(lottos);
	}

	public List<Lotto> generateLottos(int manualLottoCount, int autoLottoCount) {
		lottoGenerator.setLottoGeneratorStrategy(lottoGeneratorStrategies.get("MANUAL"));
		List<Lotto> lottos = lottoGenerator.generate(manualLottoCount);
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
