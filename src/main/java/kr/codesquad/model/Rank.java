package kr.codesquad.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NOTHING(0, 0);

    private final int count;
    private final int prize;

    Rank(int count, int prize) {
        this.count = count;
        this.prize = prize;
    }

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank find(int sameCount, Boolean isBonus) {
        if (sameCount == 5 && isBonus)
            return SECOND;

        return Arrays.stream(values())
                .filter(rank -> rank.count == sameCount)
                .findFirst()
                .orElse(NOTHING);
    }
}
