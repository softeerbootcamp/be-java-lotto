package kr.codesquad;

public class Money {
    public static final int MONEY_PER_LOTTO = 1000;
    private final int money;

    public Money(int money) {
        this.money = money;
    }
    public int countLotto(){
        return money/MONEY_PER_LOTTO;
    }
    public double calProfitRate(Money prize){
        return (prize.money- money) / (double) money * 100;
    }
}
