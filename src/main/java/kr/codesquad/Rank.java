package kr.codesquad;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5,30000000),
    FIRST(6, 2000000000);

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Map<Rank, Integer> initMap()
    {
        Map<Rank, Integer> map = new HashMap<>();
        for(Rank rank : values())
        {
            map.put(rank,0);
        }
        return map;
    }
}

