package kr.codesquad.winLotto;

public enum WinningCount {

    THREE(3, 5000, false),
    FOUR(4, 50000, false),
    FIVE(5, 1500000, false),
    FIVE_BONUS(5, 30000000, true),
    SIX(6, 2000000000, false);

    private int count;
    private int price;
    private final boolean isBonus;

    WinningCount(
            int count,
            int price,
            boolean isBonus
    ) {
        this.count = count;
        this.price = price;
        this.isBonus = isBonus;
    }


    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public boolean getIsBonus() {
        return isBonus;
    }
}
