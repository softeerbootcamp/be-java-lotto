package kr.codesquad;

public enum Rank {
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false);

    private final int countOfMatch;
    private final int winningMoney;
    private final boolean isBonus;

    Rank(int countOfMatch, int winningMoney, boolean isBonus) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.isBonus = isBonus;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean getIsBonus() {
        return isBonus;
    }
}