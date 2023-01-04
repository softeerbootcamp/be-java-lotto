package kr.codesquad;

import java.util.function.Function;

public enum Prize {
    FIRST(6, 2000000000, count -> count * 2000000000L),
    SECOND(5, 30000000, count -> count * 30000000L),  // 보너스
    THIRD(5, 1500000, count -> count * 1500000L),
    FOURTH(4, 50000, count -> count * 50000L),
    FIFTH(3, 5000, count -> count * 5000L),
    MISS(0, 0, count -> 0L);

    private int countOfMatch;

    private int winningMoney;
    private Function<Integer, Long> prizeTotal;

    public long calculatePrize(int matchCount) {
        return prizeTotal.apply(matchCount);
    }

    private static final int LEAST_MATCH_COUNT = 3;

    Prize(int countOfMatch, int winningMoney, Function<Integer, Long> prizeTotal) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.prizeTotal = prizeTotal;
    }

    public static Prize valueOf(int countOfMatch, final boolean bonus) {
        final Prize[] prizes = values();

        if (countOfMatch < LEAST_MATCH_COUNT) {  // 3개 이하 동일
            return MISS;
        }

        if (SECOND.matchCount(countOfMatch) && bonus) { // 보너스 번호 일치
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