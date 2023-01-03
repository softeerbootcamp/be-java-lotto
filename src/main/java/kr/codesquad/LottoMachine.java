package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final LottoIssue lottoIssue;
    private final LottoCheck lottoCheck;
    private final int priceOfLotto;
    private final BufferedReader br;

    public LottoMachine(int priceOfLotto) {
        this.priceOfLotto = priceOfLotto;
        this.lottoIssue = new LottoIssueImpl();
        this.lottoCheck = new LottoCheckImpl();
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public LottoTicket buy() throws IOException {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(br.readLine());
        int lottoCnt = money / priceOfLotto;

        List<Lotto> lottoList = this.lottoIssue.issue(lottoCnt);
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        return new LottoTicket(lottoList, lottoCnt * priceOfLotto);
    }


    public void checkWin(LottoTicket lottoTicket) throws IOException {
        WinningLotto winningLotto = this.getWinningLotto();
        LottoResult lottoResult = this.lottoCheck.check(lottoTicket, winningLotto);
        this.printResult(lottoResult);
    }

    private WinningLotto getWinningLotto() throws IOException {
        System.out.println("\n당첨 번호를 입력하세요.");
        List<Integer> winningNumberList = new ArrayList<>(6);
        String[] winNumArr  = br.readLine().replaceAll(" ", "").split(",");
        for (String winNum: winNumArr) winningNumberList.add(Integer.parseInt(winNum));

        System.out.println("보너스 번호를 입력하세요.");
        int bonus = Integer.parseInt(br.readLine());

        return new WinningLotto(winningNumberList, bonus);
    }

    private void printResult(LottoResult lottoResult) {
        for (Rank rank: Rank.values()) {
            String stringOfBonus = rank.isBonus() ? ", 보너스 볼 일치" : "";
            System.out.println(rank.getCountOfMatch() + "개 일치" + stringOfBonus + "(" + rank.getWinningMoney() + "원) - " + lottoResult.getRankStatus().get(rank) + "개");
        }
        System.out.println("총 수익률은 " + String.format("%.2f", lottoResult.getRate()) + "%입니다.");
    }
}
