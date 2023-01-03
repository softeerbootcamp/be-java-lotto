package kr.codesquad;

public enum Prize {
    FIRST(2000000000), SECOND(1500000), THIRD(50000), FORTH(5000), NOTHING(0);
    private int money;

    Prize(int initMoney){
        money = initMoney;
    }

    public int getMoney(){
        return money;
    }
}
