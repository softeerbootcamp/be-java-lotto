package kr.codesquad;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Statistic {
    private double rate;
    private double output = 0;
    private final Map<Integer, Integer> counts = new HashMap<>();
    public Statistic() {
        counts.put(Rank.FIRST.getWinningMoney(), 0);
        counts.put(Rank.SECOND.getWinningMoney(), 0);
        counts.put(Rank.THIRD.getWinningMoney(), 0);
        counts.put(Rank.FOURTH.getWinningMoney(), 0);
        counts.put(Rank.FIFTH.getWinningMoney(), 0);
    }

    public void calculateRate(int input) {
        this.rate = ((output - input) / input) * 100;
    }

    public void calculateOutput(Row row) {
        int match = row.getMatch();
        boolean matchBonus = row.isBonus();
        if (match >= 3) {
            int money = Rank.getMoney(match, matchBonus);
//            Rank rank = Rank.valueOf(match, matchBonus);
            int cnt = counts.get(money);
            counts.put(money, ++cnt);
            this.output += money;
        }
    }

    public void printStatistics() {
        System.out.println("당첨 통계\n" + "---------");

        Rank[] ranks = Rank.values();
        Arrays.sort(ranks, Collections.reverseOrder());
        for (Rank rank : ranks) {
            System.out.println(rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원)- " + counts.get(rank.getWinningMoney()) + "개");

        }
        System.out.println("총 수익률은 " + String.format("%.2f", rate) + "% 입니다.");
    }
}
