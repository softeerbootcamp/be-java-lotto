package kr.codesquad;

import java.util.function.Function;

public enum Prize {
    FIRST(6, 2000000000, count -> count * 2000000000),
    SECOND(5, 30000000, count -> count * 30000000),  // 보너스
    THIRD(5, 1500000, count -> count * 1500000),
    FOURTH(4, 50000, count -> count * 50000),
    FIFTH(3, 5000, count -> count * 5000),
    MISS(0, 0, count -> 0);

    private int countOfMatch;

    private int winningMoney;

    private Function<Integer, Integer> prizeTotal;

    public int calculatePrize(int matchCount) {
        return prizeTotal.apply(matchCount);
    }

    private static final int LEAST_MATCH_COUNT = 3;

    private Prize(int countOfMatch, int winningMoney, Function<Integer, Integer> prizeTotal) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.prizeTotal = prizeTotal;
    }

    public static Prize valueOf(int countOfMatch, final boolean bonus) {
        final Prize[] prizes = values();

        if (countOfMatch < LEAST_MATCH_COUNT) {
            return MISS;
        }

        if (SECOND.matchCount(countOfMatch) && bonus) {
            return SECOND;
        }

        if (SECOND.matchCount(countOfMatch) && !bonus) {
            return THIRD;
        }

        for(Prize prize : prizes) {
            if(prize.getCountOfMatch() == countOfMatch)
                return prize;
        }

        return null;
    }

    private boolean matchCount(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }
    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

}