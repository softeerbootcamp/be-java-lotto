package kr.codesquad.domain;

public class Money {

    private final int LOTTO_PRICE = 1000;
    private int money;
    public Money(int money) {
        this.money = money;
    }
    public int calculateLottoCount() {
        return money / LOTTO_PRICE;
    }
}