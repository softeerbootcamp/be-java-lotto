package kr.codesquad;

public enum Prize {
    FIRST(2000000000), SECOND(3000000), THIRD(1500000), FORTH(50000), FIFTH(5000), NOTHING(0);
    private static final Prize[] prizes = {NOTHING, NOTHING, NOTHING, FIFTH, FORTH, THIRD, FIRST};

    private int money;

    Prize(int initMoney){
        money = initMoney;
    }

    public int getMoney(){
        return money;
    }

    public static Prize getPrize(int fitCount, boolean isBonusCorrect){
        if(fitCount == 5 && isBonusCorrect)
            return SECOND;
        return prizes[fitCount];
    }
}
