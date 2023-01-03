package kr.codesquad;

public enum LottoMatchType {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000),

    BONUS_MATCH(7, 30000000);

    LottoMatchType(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMoney() {
        return money;
    }

    private final int matchCount;
    private final int money;
}
