package kr.codesquad;

import java.util.*;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int countOfMatch;
    private final int winningMoney;

//    private static final Map<Integer, Integer> MAP = new HashMap<>();
//    static {
//        MAP.put(FIRST.getCountOfMatch(), FIRST.getWinningMoney());
//        MAP.put(THIRD, THIRD.getWinningMoney());
//        MAP.put(FOURTH, FOURTH.getWinningMoney());
//        MAP.put(FIFTH, FIFTH.getWinningMoney());
//    }
//

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    //todo: bonus 구현 필요, depth1 유지 필요
    public static int getMoney(int countOfMatch, boolean matchBonus) {
        Rank[] ranks = Rank.values();

        if (countOfMatch < 3) {
            throw new IllegalArgumentException();
        }
        for (Rank rank : ranks) {
            return valueOf(countOfMatch, matchBonus).winningMoney;
        }
        return 0;
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

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
