package kr.codesquad;

public enum WinningPrize {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    private static final int LEAST_MATCH_COUNT = 3;

    private WinningPrize(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public WinningPrize valueOf(int countOfMatch, int winningMoney) {
        final WinningPrize[] prizes = values();

        if (countOfMatch < LEAST_MATCH_COUNT) {
            return MISS;
        }

        for(WinningPrize prize : prizes) {
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