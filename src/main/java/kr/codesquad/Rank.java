package kr.codesquad;

import java.util.Map;

public enum Rank {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false);

    Rank(int countOfMatch, int winningMoney, boolean isBonus) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.isBonus = isBonus;
    }
    private final int countOfMatch;
    private final int winningMoney;
    private final boolean isBonus;

    public boolean isBonus() {
        return isBonus;
    }

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
