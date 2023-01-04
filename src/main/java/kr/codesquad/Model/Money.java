package kr.codesquad.Model;

public class Money {
    private int money;

    public Money(int money) { this.money = money; }
    public int countLottos() { return money / 1000; }


}
