package kr.codesquad.enums;

public enum Rank {
    NOTHING(0, 0),
    FIFTH(3, 5000),
    FORTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);
    private static final int WIN_MINIMUM = 3;
    private int score;
    private int money;

    Rank(int score, int money) {
        this.score = score;
        this.money = money;
    }

    public int getScore() {
        return score;
    }

    public int getMoney() {
        return money;
    }

    public static Rank valueOf(int score, boolean bonus) {
        if (score < WIN_MINIMUM) {
            return NOTHING;
        }
        if (score == SECOND.score && bonus) {
            return SECOND;
        }
        for (Rank value : values()) {
            if (value.score == score) {
                return value;
            }
        }
        return null;
    }
}
