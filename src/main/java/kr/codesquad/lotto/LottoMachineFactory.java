package kr.codesquad.lotto;

import kr.codesquad.lotto.check.LottoCheckImpl;
import kr.codesquad.lotto.issue.LottoIssueImpl;
import kr.codesquad.lotto.issue.AutoLottoIssueStrategy;
import kr.codesquad.lotto.issue.ManualLottoIssueStrategy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public final class LottoMachineFactory {

    private static final int priceOfLotto = 1000;

    public static LottoMachine createLottoMachine() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return new LottoMachine(
                priceOfLotto,
                new LottoIssueImpl(),
                new LottoCheckImpl(),
                Map.of("AUTO", new AutoLottoIssueStrategy(), "MANUAL", new ManualLottoIssueStrategy(br)),
                br);
    }
}
