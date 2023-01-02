package kr.codesquad;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private int countOfMatch;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
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