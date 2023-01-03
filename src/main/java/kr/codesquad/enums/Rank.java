package kr.codesquad.enums;

public enum Rank {
    FIFTH(3, 5000, false),
    FORTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false);
    private int score;
    private int money;
    private boolean bonus;

    Rank(int score, int money, boolean bonus) {
        this.score = score;
        this.money = money;
        this.bonus = bonus;
    }

    public int getScore() {
        return score;
    }

    public int getMoney() {
        return money;
    }

    public static Rank getRankByScoreAndBonus(int score, boolean bonus) {
        if (score < 3) return null;
        Rank rank = null;
        for (Rank value : values()) {
            rank = findRank(score, bonus, value, rank);
        }
        return rank;
    }

    private static Rank findRank(int score, boolean bonus, Rank value, Rank rank) {
        if (value.score == score && value.bonus == bonus) {
            return value;
        }
        return rank;
    }
}
