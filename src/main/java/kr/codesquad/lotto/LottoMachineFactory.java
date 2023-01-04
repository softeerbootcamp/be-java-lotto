package kr.codesquad.lotto;

import kr.codesquad.lotto.check.LottoCheckImpl;
import kr.codesquad.lotto.issue.LottoIssueImpl;
import kr.codesquad.lotto.issue.AutoLottoIssueStrategy;
import kr.codesquad.lotto.issue.LottoIssueStrategy;
import kr.codesquad.lotto.issue.ManualLottoIssueStrategy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public final class LottoMachineFactory {

    private static final int priceOfLotto = 1000;

    public static LottoMachine createLottoMachine() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, LottoIssueStrategy> lottoIssueStrategyMap =
                Map.of("AUTO", new AutoLottoIssueStrategy(), "MANUAL", new ManualLottoIssueStrategy(br));
        return new LottoMachine(
                priceOfLotto,
                new LottoIssueImpl(lottoIssueStrategyMap.get("AUTO")),
                new LottoCheckImpl(),
                lottoIssueStrategyMap,
                br);
    }
}
