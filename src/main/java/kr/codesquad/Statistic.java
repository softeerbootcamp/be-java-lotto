package kr.codesquad;

import java.util.HashMap;
import java.util.Map;

public class Statistic {
    private double rate;
    private double output = 0;
    //todo: counts 처리 유지보수 편리하게 수정 필요.
    private final Map<Rank, Integer> counts = new HashMap<>();

    private int column;
    public Statistic(int column) {
        this.column = column;
        counts.put(Rank.FIRST, 0);
        counts.put(Rank.SECOND, 0);
        counts.put(Rank.THIRD, 0);
        counts.put(Rank.FOURTH, 0);
        counts.put(Rank.FIFTH, 0);
    }

    public void calculateRate(int input) {
        this.rate = ((output - input) / input) * 100;
    }

    public void calculateOutput(Row row) {
        int match = row.getMatch();
        int money = Rank.getMoney(match);
        boolean matchBonus = row.isBonus();
        if (match >= 3) {
            Rank rank = Rank.valueOf(match, matchBonus);
            int cnt = counts.get(rank);
            counts.put(rank, ++cnt);
            this.output += money;
        }
    }

    public void printStatistics() {
        System.out.println("당첨 통계\n" + "---------");

        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            System.out.println(rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원)- " + counts.get(rank) + "개");

        }
        for (int i = 3; i <= 6; i++) {
        }
        System.out.println("총 수익률은 " + String.format("%.2f", rate) + "% 입니다.");


    }
}
