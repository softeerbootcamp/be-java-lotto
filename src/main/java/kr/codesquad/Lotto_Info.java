package kr.codesquad;

public enum Lotto_Info {
    LOTTO_PRICE(1000),
    LOTTO_SIZE(6);

    private int value;

    Lotto_Info(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
