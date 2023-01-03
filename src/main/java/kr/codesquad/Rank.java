package kr.codesquad;

public enum Rank {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }
    public int getCountOfMatch() {
        return countOfMatch;
    }
    public int getWinningMoney() {
        return winningMoney;
    }
}

