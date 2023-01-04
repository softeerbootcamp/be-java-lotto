package kr.codesquad.lotto;

import kr.codesquad.lotto.io.LottoIOManager;
import kr.codesquad.lotto.io.LottoIOManagerImpl;
import kr.codesquad.lotto.issue.LottoIssueImpl;
import kr.codesquad.lotto.issue.AutoLottoIssueStrategy;
import kr.codesquad.lotto.issue.LottoIssueStrategy;
import kr.codesquad.lotto.issue.ManualLottoIssueStrategy;

import java.util.Map;

public final class LottoMachineFactory {

    private static final int priceOfLotto = 1000;

    public static LottoMachine createLottoMachine() {
        LottoIOManager lottoIOManager = new LottoIOManagerImpl();
        Map<String, LottoIssueStrategy> lottoIssueStrategyMap =
                Map.of("AUTO", new AutoLottoIssueStrategy(), "MANUAL", new ManualLottoIssueStrategy(lottoIOManager));
        return new LottoMachine(
                priceOfLotto,
                new LottoIssueImpl(lottoIssueStrategyMap.get("AUTO")),
                lottoIssueStrategyMap,
                lottoIOManager);
    }
}
