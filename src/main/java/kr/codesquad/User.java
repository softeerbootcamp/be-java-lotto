package kr.codesquad;

public class User {
    private static final int MONEY_PER_LOTTO = 1_000;
    private final int money;

    public User(int money) {
        this.money = money;
    }

    public int countOfBuying(){
        return money / MONEY_PER_LOTTO;}

}
