package kr.codesquad.lotto;

import kr.codesquad.lotto.io.LottoIOManager;
import kr.codesquad.lotto.issue.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        int autoLottoCnt = lottoCnt - manualLottoList.size();

        lottoIssue.setLottoIssueStrategy(issueStrategyMap.get("AUTO"));
        List<Lotto> autoLottoList = lottoIssue.issue(autoLottoCnt);
        manualLottoList.addAll(autoLottoList);

        return manualLottoList;
    }


    public Map<Rank, Integer> checkWin(LottoTicket lottoTicket) {
        WinningLotto winningLotto = getWinningLotto();
        Map<Rank, Integer> rankStatus = new HashMap<>(Rank.getInitRankStatus());
        for (Lotto lotto: lottoTicket.getLottoList()) {
            Rank match = winningLotto.match(lotto);
            int matchCount = rankStatus.get(match);
            rankStatus.put(match, matchCount + 1);
        }

        return rankStatus;
    }

    private WinningLotto getWinningLotto() {
        Lotto winningLotto = new Lotto(lottoIOManager.readLottoNumberSet("\n당첨 번호를 입력하세요."));
        LottoNumber bonus = lottoIOManager.readLottoNumber("보너스 번호를 입력하세요.");
        return new WinningLotto(winningLotto, bonus);
    }
}
