package kr.codesquad;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static int getMoney(int countOfMatch) {
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            if (rank.countOfMatch == countOfMatch) {
                //bonus 구현 필요, depth1 유지 필요
                return rank.winningMoney;
            }
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
