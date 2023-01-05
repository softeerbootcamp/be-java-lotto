package kr.codesquad.lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        System.out.println("당첨 통계\n---------");
        List<Rank> ranks = rankStatus.keySet().stream().sorted().collect(Collectors.toList());

        for (Rank rank: ranks) {
            if (rank == Rank.MISS) continue;
            System.out.print(rank.getCountOfMatch() + "개 일치, ");

            if (Rank.isBonus(rank)) {
                System.out.print("보너스 볼 일치");
            }
            System.out.println("(" + rank.getWinningMoney() + "원) - " + rankStatus.get(rank));
        }
        System.out.println(profitRate() + "%");
    }
}