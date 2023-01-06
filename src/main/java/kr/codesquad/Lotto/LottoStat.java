package kr.codesquad.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.codesquad.Lotto.Prize.*;

public class LottoStat {

    private long totalMoney;
    private final Map<Prize, Integer> winnings;
    private final List<Lotto> lottos;
    private final WinLotto winLotto;
    private double roi;

    public LottoStat(List<Lotto> lottos, WinLotto winLotto) {
        this.lottos = lottos;
        this.winLotto = winLotto;
        winnings = new HashMap<>();
        calcResult();
    }

    private void calcResult() {
        for (Prize prize : Prize.values()) {
            winnings.put(prize, 0);
        }
        for (Lotto lotto : lottos) {
            Prize prize = Prize.calcPrize(winLotto, lotto);
            winnings.put(prize, winnings.get(prize) + 1);
            totalMoney += prize.getMoney();
        }
        roi = (double) (totalMoney - lottos.size() * 1000L) / (lottos.size() * 1000) * 100;
        if (lottos.size() == 0)
            roi = 0;
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n---------\n");
        sb.append(String.format("3개 일치 (5000원)- %d개%n", winnings.get(FIFTH)));
        sb.append(String.format("4개 일치 (50000원)- %d개%n", winnings.get(FORTH)));
        sb.append(String.format("5개 일치 (15000원)- %d개%n", winnings.get(THIRD)));
        sb.append(String.format("5개 일치, 보너스 볼 일치(30000000원) - %d개%n", winnings.get(SECOND)));
        sb.append(String.format("6개 일치 (2000000000)- %d개%n", winnings.get(FIRST)));
        sb.append(String.format("총 수익률은 %.2f", roi)).append("%입니다.");
        return sb.toString();
    }

}
