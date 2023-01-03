package kr.codesquad;

import java.util.Map;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }
    private int countOfMatch;
    private int winningMoney;

    public int getCountOfMatch() {
        return this.countOfMatch;
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }

    public static Map<Rank, Integer> getInitRankStatus() {
        return Map.of(Rank.FIRST, 0, Rank.SECOND, 0, Rank.THIRD, 0, Rank.FOURTH, 0, Rank.FIFTH, 0);
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        Rank[] ranks = values();
        for (Rank rank : ranks) {
            if (countOfMatch == SECOND.countOfMatch) {
                return matchBonus ? SECOND : THIRD;
            }

            if (rank.countOfMatch == countOfMatch) {
                return rank;
            }
        }

        return null;
    }
}
