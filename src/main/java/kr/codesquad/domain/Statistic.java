package kr.codesquad.domain;

import java.util.*;

public class Statistic {
    private final double input;
    private double output;
    private double rate;
    public static final int SINGLE_PRICE = 1000; //로또 한 장의 가격은 1000원이다.

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

    public static int getRowCountICanBuy(int inputMoney) {
        if (inputMoney < Statistic.SINGLE_PRICE) {
            throw new IllegalArgumentException("금액 1000미만임.");
        }
        return inputMoney / SINGLE_PRICE;
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
