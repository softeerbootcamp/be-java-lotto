package kr.codesquad.Model;

public enum Price {
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    BONUS(5, 30000000),
    FIRST(6, 2000000000);
    private int countOfMatch;   //일치 개수
    private double winningMoney;   //상금

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public double getWinningMoney() {
        return winningMoney;
    }

    Price(int countOfMatch, double winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    //if문 없애야함.. indent 제한..
    public static Price valueOf(int countOfMatch, boolean matchBonus) {
        Price[] prices = values();
        Price rtnPrice = null;
        for (Price price : prices)
            rtnPrice = calcPrice(rtnPrice, price, countOfMatch, matchBonus);
        return rtnPrice;
    }

    private static Price calcPrice(Price rtnPrice, Price price, int countOfMatch, boolean matchBonus) {
        if (rtnPrice != null) return rtnPrice;
        if (countOfMatch == SECOND.countOfMatch)   //2등 or 보너스
            rtnPrice = matchBonus ? BONUS : SECOND;
        if (price.countOfMatch == countOfMatch)
            rtnPrice = price;
        return rtnPrice;
    }
}
