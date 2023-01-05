package kr.codesquad.domain;


import kr.codesquad.enums.Rank;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<Rank, Integer> resultMap;

    public LottoResult() {
        resultMap = new HashMap<>();
        for (Rank value : Rank.values()) {
            resultMap.put(value, 0);
        }
    }

    public void increaseCountOfRank(Rank rank) {
        resultMap.put(rank, resultMap.get(rank) + 1);
    }

    public double calculateEarningRate(Money money) {
        double earnMoney = calculateEarnedMoney();
        return money.calculateEarningRate(earnMoney);
    }

    private long calculateEarnedMoney() {
        long earnMoney = 0;
        for (Rank rank : Rank.values()) {
            earnMoney += rank.getMoney() * resultMap.get(rank);
        }
        return earnMoney;
    }

    public String statisticToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n");
        sb.append("---------\n");

        for (Rank rank : Rank.values()) {
            sb.append(matchDetailToString(rank, resultMap.get(rank)));
        }
        return sb.toString();
    }

    private String matchDetailToString(Rank rank, int count) {
        if (rank == Rank.NOTHING) {
            return "";
        }
        if (rank == Rank.SECOND) {
            return rank.getScore() + "개 일치, 보너스 볼 일치(" + rank.getMoney() + "원)- " + count + "개\n";
        }
        return rank.getScore() + "개 일치 (" + rank.getMoney() + "원)- " + count + "개\n";
    }

    public String earnedRateToString(Money money) {
        double rate = calculateEarningRate(money);
        double rateOfIncome = Math.floor(rate * 100) / 100;
        if (rate < 0) {
            rateOfIncome = Math.ceil(rate * 100) / 100;
        }
        return "총 수익률은 " + rateOfIncome + "%입니다.\n";
    }
}
