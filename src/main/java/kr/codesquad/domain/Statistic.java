package kr.codesquad.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Statistic {

    private final Money money;
    private double output;
    private double rate;

    private static final Map<Rank, Integer> counts = new HashMap<>();

    public Statistic(Money money) {
        this.money = money;
        counts.put(Rank.FIRST, 0);
        counts.put(Rank.SECOND, 0);
        counts.put(Rank.THIRD, 0);
        counts.put(Rank.FOURTH, 0);
        counts.put(Rank.FIFTH, 0);
    }

    public void calculate(Lotto lotto) {
        List<Row> totalLotto = lotto.getTotalLotto();
        for (Row row : totalLotto) {
            calculateOutput(row);
        }
        this.calculateRate();
    }

    public void calculateRate() {
        this.rate = ((output - money.getTotalMoney()) / money.getTotalMoney()) * 100;
    }

    public void calculateOutput(Row row) {
        int match = row.getMatch();
        boolean matchBonus = row.isBonus();
        Rank rank = Rank.valueOf(match, matchBonus);
        if (rank != Rank.MISS) {
            int cnt = counts.get(rank);
            counts.put(rank, ++cnt);
            this.output += rank.getWinningMoney();
        }
    }

    public void printStatistics() {
        System.out.println("당첨 통계\n" + "---------");
        List<Rank> ranks = Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.MISS)).sorted(Collections.reverseOrder()).collect(Collectors.toList());

        for (Rank rank : ranks) {
           printEachRank(rank);
        }
        System.out.println("총 수익률은 " + String.format("%.2f", rate) + "% 입니다.");
    }

    public void printEachRank(Rank rank) {
        System.out.print(rank.getCountOfMatch() + "개 일치");
        if (rank == Rank.SECOND) {
            System.out.print(", 보너스 볼 일치");
        }
        System.out.println(" (" + rank.getWinningMoney() + "원)- " + counts.get(rank) + "개");
    }
}
