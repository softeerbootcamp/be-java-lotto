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

    public static int convertStringToMoney(String input) throws NumberFormatException {
        return Integer.parseInt(input);
    }

    public double calculateEarningRate(double earnMoney) {
        return (earnMoney - (double) money) / (double) money * 100;
    }
    public void buyManualLotto(int LottoCount) {
        this.money -= LottoCount * LOTTO_PRICE;
    }

    public int sum(Money ManualMoney) {
        return this.money + ManualMoney.money;
    }
}