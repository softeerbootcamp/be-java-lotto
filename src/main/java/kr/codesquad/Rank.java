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

    private static final Map<Integer, Integer> MAP = new HashMap<>();
    static {
        MAP.put(FIRST.getCountOfMatch(), FIRST.getWinningMoney());
        MAP.put(THIRD.getCountOfMatch(), THIRD.getWinningMoney());
        MAP.put(FOURTH.getCountOfMatch(), FOURTH.getWinningMoney());
        MAP.put(FIFTH.getCountOfMatch(), FIFTH.getWinningMoney());
    }

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static int getMoney(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == SECOND.countOfMatch) {
            return matchBonus ? SECOND.winningMoney : THIRD.winningMoney;
        }
        if (countOfMatch >= 3) {
            return MAP.get(countOfMatch);
        }
        return 0;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
