package kr.codesquad.Model;

public class Money {
    private int money;

    public Money(int money) { this.money = money; }
    public int countLottos() { return money / 1000; }

    public Money sum(Money money){ return new Money(this.money + money.money); }

    public double profitRate(Money prize) {
        return (prize.money * 100) / money;
    }

}
