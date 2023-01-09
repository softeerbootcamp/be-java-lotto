package kr.codesquad.domain;

public class Money {

    private static final int MIN_PRICE = 1000;

    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private void validateMoney(int money) {
        if (money < MIN_PRICE) {
            throw new IllegalArgumentException("1000원 이상을 지불해 주세요.");
        }
    }

    public int moneyDivide(int denominator) {
        return money / denominator;
    }

}
