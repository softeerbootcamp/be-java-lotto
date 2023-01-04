package kr.codesquad.Model;

public class Money {
    private int money;

    public Money(int money) { this.money = money; }
    public int countLottos() { return money / 1000; }

    public Money sum(Money money){ return new Money(this.money + money.money); }

    public double profitRate(Money prize) {
        return ((prize.money - money) / (double) money) * 100;
    }

    public String toString(){
        return "Money : " + money;
    }

}
