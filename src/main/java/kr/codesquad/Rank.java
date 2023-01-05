package kr.codesquad;

public enum Rank {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    ETC(0, 0);

    private final int countOfMatch;
    private final int winningMoney;


    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        Rank[] ranks = values();
        for (Rank rank : ranks) {
            if (countOfMatch == SECOND.countOfMatch) {
                return matchBonus ? SECOND : THIRD;
            }

            if (rank.countOfMatch == countOfMatch) {
                return rank;
            }
        }

        return null;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int prize(int countOfMatchLotto) {
        return (countOfMatchLotto * winningMoney);
    }
}


