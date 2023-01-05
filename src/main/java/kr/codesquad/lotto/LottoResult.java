package kr.codesquad.lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> rankStatus;

    private final int money;

    public LottoResult(int money) {
        this.rankStatus = new HashMap<>(Rank.getInitRankStatus());
        this.money = money;
    }

    public void putRank(Rank rank) {
        rankStatus.put(rank, rankStatus.get(rank) + 1);
    }

    public int prize() {
        int prize = 0;

        for (Rank rank: rankStatus.keySet()) {
            prize += rank.getWinningMoney() * rankStatus.get(rank);
        }

        return prize;
    }

    public double profitRate() {
        return (double)(prize() - money) / (double) money;
    }

    public void print() {

    }
}
