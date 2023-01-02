package kr.codesquad;

public enum Rank {
    FIRST(6, 2000000000, 1),
    SECOND(5, 1500000, 2),
    THIRD(4, 50000, 3),
    FOURTH(3, 5000, 4);

    private int countOfMatch;
    private int winningMoney;
    private int rank;

    Rank(int countOfMatch, int winningMoney, int rank) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.rank = rank;
    }

    public int getRank() {
        return this.rank;
    }

    public int getCountOfMatch() {
        return this.countOfMatch;
    }
    public int getWinningMoney() {
        return this.winningMoney;
    }

    public static Rank valueOf(int countOfMatch) {
        Rank[] ranks = values();
        for (Rank rank : ranks) {
            if (rank.countOfMatch == countOfMatch) {
                return rank;
            }
        }
        return null;
    }
}