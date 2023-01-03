package kr.codesquad;

public enum WinningCount {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private int count;
    private int price;

    WinningCount(
            int count,
            int price
    ) {
        this.count = count;
        this.price = price;
    }


    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }
}