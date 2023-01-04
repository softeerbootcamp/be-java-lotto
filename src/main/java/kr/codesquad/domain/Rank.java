package kr.codesquad.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    NOTHING(0, 0, false);

    private final int winningAmount;

    private final int count;

    private final boolean isBounsBall;

    Rank(
            int winningAmount,
            int count,
            boolean isBounsBall
    ) {
        this.winningAmount = winningAmount;
        this.count = count;
        this.isBounsBall = isBounsBall;
    }

    public static Rank getRank(
            int matchCount,
            boolean isBonus
    ) {
        return Arrays.stream(values())
                .filter(rank -> rank.count == matchCount && rank.isBounsBall == isBonus)
                .findFirst()
                .orElse(NOTHING);
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public int getCount() {
        return count;
    }

    public boolean isBouns() {
        return isBounsBall;
    }

}
