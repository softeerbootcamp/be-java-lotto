package kr.codesquad;

import java.util.*;

public class LottoCheckImpl implements LottoCheck {

    @Override
    public LottoResult check(LottoTicket lottoTicket, WinningLotto winningLotto) {
        Map<Rank, Integer> rankStatus = new HashMap<>(Rank.getInitRankStatus());
        for (Lotto lotto: lottoTicket.getLottoList()) {
            Rank rank = calcRank(lotto, winningLotto);
            if (rank == null) continue;
            int totalCnt = rankStatus.getOrDefault(rank, rank.ordinal());
            rankStatus.put(rank, totalCnt + 1);
        }
        double rate = calcRate(rankStatus, lottoTicket.getMoney());
        return new LottoResult(rankStatus, rate);
    }

    private Rank calcRank(Lotto lotto, WinningLotto winningLotto) {
        int targetedCount = lotto.targetedCount(winningLotto);
        boolean hasBonus = lotto.hasBonus(winningLotto);
        return Rank.valueOf(targetedCount, hasBonus);
    }

    private double calcRate(Map<Rank, Integer> rankStatus, int money) {
        int totalMoney = 0;
        for (Rank rank: Rank.values()) {
            totalMoney += rank.getWinningMoney() * rankStatus.get(rank);
        }
        return (((double) totalMoney - money) / (double) money) * 100;
    }
}
