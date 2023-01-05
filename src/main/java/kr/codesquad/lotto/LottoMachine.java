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

        List<Lotto> lottoList = issueLotto(lottoCnt);

        System.out.println(lottoList.size() + "개를 구매했습니다.");
        return new LottoTicket(lottoList, lottoCnt * priceOfLotto);
    }

    private List<Lotto> issueLotto(int lottoCnt) {
        lottoIssue.setLottoIssueStrategy(issueStrategyMap.get("MANUAL"));
        List<Lotto> manualLottoList = lottoIssue.issue(lottoCnt);

        lottoIssue.setLottoIssueStrategy(issueStrategyMap.get("AUTO"));
        List<Lotto> autoLottoList = lottoIssue.issue(lottoCnt - manualLottoList.size());

        return Stream
                .concat(manualLottoList.stream(), autoLottoList.stream())
                .collect(Collectors.toList());
    }


    public LottoResult checkWin(LottoTicket lottoTicket) {
        WinningLotto winningLotto = getWinningLotto();
        return lottoTicket.match(winningLotto);
    }

    private WinningLotto getWinningLotto() {
        Lotto winningLotto = new Lotto(lottoIOManager.readLottoNumberSet("\n당첨 번호를 입력하세요."));
        LottoNumber bonus = lottoIOManager.readLottoNumber("보너스 번호를 입력하세요.");
        return new WinningLotto(winningLotto, bonus);
    }
}
