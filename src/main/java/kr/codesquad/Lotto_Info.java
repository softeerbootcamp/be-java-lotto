package kr.codesquad;

import java.util.ArrayList;

public enum Lotto_Info {
    LOTTO_PRICE(1000),
    LOTTO_CNT(6);
    private int value;

    Lotto_Info(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
