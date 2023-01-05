package kr.codesquad.lotto;

import kr.codesquad.lotto.io.LottoIOManager;
import kr.codesquad.lotto.issue.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {

    private final int priceOfLotto;
    private final LottoIssue lottoIssue;
    private final Map<String, LottoIssueStrategy> issueStrategyMap;

    private final LottoIOManager lottoIOManager;

    public LottoMachine(int priceOfLotto, LottoIssue lottoIssue, Map<String, LottoIssueStrategy> issueStrategyMap, LottoIOManager lottoIOManager) {
        this.priceOfLotto = priceOfLotto;
        this.lottoIssue = lottoIssue;
        this.issueStrategyMap = issueStrategyMap;
        this.lottoIOManager = lottoIOManager;
    }

    public LottoTicket buy() {
        int money = lottoIOManager.readPurchasePrice();
        int lottoCnt = money / priceOfLotto;

        List<Lotto> lottos = issueLotto(lottoCnt);

        System.out.println(lottos.size() + "개를 구매했습니다.");
        return new LottoTicket(lottos, lottoCnt * priceOfLotto);
    }

    private List<Lotto> issueLotto(int lottoCnt) {
        lottoIssue.setLottoIssueStrategy(issueStrategyMap.get("MANUAL"));
        List<Lotto> manualLottos = lottoIssue.issue(lottoCnt);

        lottoIssue.setLottoIssueStrategy(issueStrategyMap.get("AUTO"));
        List<Lotto> autoLottos = lottoIssue.issue(lottoCnt - manualLottos.size());

        return Stream
                .concat(manualLottos.stream(), autoLottos.stream())
                .collect(Collectors.toList());
    }


    public LottoResult checkWin(LottoTicket lottoTicket) {
        WinningLotto winningLotto = lottoIOManager.readWinningLottoNumber();
        return lottoTicket.match(winningLotto);
    }
}
