package kr.codesquad.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    NOTHING(0, 0, false);

    private final int count;
    private final int prize;
    private final boolean isBonus;

    Rank(int count, int prize, boolean isBonus) {
        this.count = count;
        this.prize = prize;
        this.isBonus = isBonus;
    }

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public static Rank find(int sameCount, Boolean isBonus) {
        if (sameCount == 5 && isBonus)
            return SECOND;

        return Arrays.stream(values())
                .filter(rank -> rank != Rank.SECOND)
                .filter(rank -> rank.count == sameCount)
                .findFirst()
                .orElse(NOTHING);
    }
}
