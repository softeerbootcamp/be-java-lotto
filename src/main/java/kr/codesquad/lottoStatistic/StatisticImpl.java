package kr.codesquad.lottoStatistic;

import kr.codesquad.Rank;

import java.util.Map;

public class StatisticImpl implements Statistic{
    @Override
    public double countProfit(int money, Map<Rank, Integer> result) {
        return ((getTotalIncome(result) - money) / money) * 100;
    }

    public double getTotalIncome(Map<Rank, Integer> result) {
        double total = 0;
        for(Rank rank : Rank.values()) {
            total += rank != Rank.MISS ? result.get(rank) * rank.getWinningMoney() : 0;
        }

        return total;
    }
}
