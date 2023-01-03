package kr.codesquad;

public enum Rank {
    FIRST(6, 2000000000, 0),
    SECOND(5, 30000000, 0),
    THIRD(5, 1500000, 0),
    FOURTH(4, 50000, 0),
    FIFTH(3, 5000, 0);

    private int countOfMatch;
    private int winningMoney;

    private int winningCount;

    Rank(int countOfMatch, int winningMoney, int winningCount) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.winningCount = winningCount;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
    public int getWinningCount() {
        return winningCount;
    }
    public void setWinningCount(int winningCount) {
        this.winningCount = winningCount;
    }
}

