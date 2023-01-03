package kr.codesquad;

public enum Rank {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    ETC(0, 0, false);

    private final int countOfMatch;
    private final int winningMoney;
    private final boolean bonus;


    Rank(int countOfMatch, int winningMoney, boolean bonus) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.bonus = bonus;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean isBonus() {
        return bonus;
    }
}

