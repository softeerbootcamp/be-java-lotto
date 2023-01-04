package kr.codesquad.lotto;

import kr.codesquad.lotto.check.LottoCheck;
import kr.codesquad.lotto.io.LottoIOManager;
import kr.codesquad.lotto.issue.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoMachine {

    private final int priceOfLotto;
    private final LottoIssue lottoIssue;
    private final LottoCheck lottoCheck;
    private final Map<String, LottoIssueStrategy> issueStrategyMap;

    private final LottoIOManager lottoIOManager;

    public LottoMachine(int priceOfLotto, LottoIssue lottoIssue, LottoCheck lottoCheck, Map<String, LottoIssueStrategy> issueStrategyMap, LottoIOManager lottoIOManager) {
        this.priceOfLotto = priceOfLotto;
        this.lottoIssue = lottoIssue;
        this.lottoCheck = lottoCheck;
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


    public void checkWin(LottoTicket lottoTicket) {
        WinningLotto winningLotto = this.getWinningLotto();
        LottoResult lottoResult = this.lottoCheck.check(lottoTicket, winningLotto);
        lottoIOManager.printLottoResult(lottoResult);
    }

    private WinningLotto getWinningLotto() {
        List<LottoNumber> winningNumberList = new ArrayList<>(lottoIOManager.readLottoNumberSet("\n당첨 번호를 입력하세요."));
        LottoNumber bonus = lottoIOManager.readLottoNumber("보너스 번호를 입력하세요.");

        return new WinningLotto(winningNumberList, bonus);
    }
}
