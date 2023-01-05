package kr.codesquad.domain;

import java.util.*;

public class Statistic {
    private final double input;
    private double output;
    private double rate;

    private static final Map<Rank, Integer> counts = new HashMap<>();

    public Statistic(int inputMoney) {
        this.input = inputMoney;
        counts.put(Rank.FIRST, 0);
        counts.put(Rank.SECOND, 0);
        counts.put(Rank.THIRD, 0);
        counts.put(Rank.FOURTH, 0);
        counts.put(Rank.FIFTH, 0);
        counts.put(Rank.MISS, 0);
    }

    public void calculate(Lotto lotto) {
        List<Row> totalLotto = lotto.getTotalLotto();
        for (Row row : totalLotto) {
            calculateOutput(row);
        }
        this.calculateRate();
    }

    public void calculateRate() {
        this.rate = ((output - input) / input) * 100;
    }

    public void calculateOutput(Row row) {
        int match = row.getMatch();
        boolean matchBonus = row.isBonus();
        Rank rank = Rank.valueOf(match, matchBonus);
        int cnt = counts.get(rank);
        counts.put(rank, ++cnt);
        this.output += rank.getWinningMoney();

    }

    public void printStatistics() {
        System.out.println("당첨 통계\n" + "---------");
        Rank[] ranks = Rank.values();
        Arrays.sort(ranks, Collections.reverseOrder());
        for (Rank rank : ranks) {
            System.out.print(rank.getCountOfMatch() + "개 일치");
            isBonusRank(rank);
            System.out.println(" (" + rank.getWinningMoney() + "원)- " + counts.get(rank) + "개");
        }
        System.out.println("총 수익률은 " + String.format("%.2f", rate) + "% 입니다.");
    }

    public void isBonusRank(Rank rank) {
        if (rank.getWinningMoney() == Rank.SECOND.getWinningMoney()) {
            System.out.print(", 보너스 볼 일치");
        }
    }
}
