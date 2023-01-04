package kr.codesquad.Model;

import java.util.*;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

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

    public static final Map<Integer, List<Rank>> map = new HashMap<>();
    static{
        map.put(FIRST.getCountOfMatch(), List.of(FIRST));
        map.put(SECOND.getCountOfMatch(), List.of(SECOND, THIRD));
        map.put(FOURTH.getCountOfMatch(), List.of(FOURTH));
        map.put(FIFTH.getCountOfMatch(), List.of(FIFTH));
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if(map.get(countOfMatch) == null) return null;
        return countOfMatch == SECOND.countOfMatch && !matchBonus? map.get(countOfMatch).get(1) : map.get(countOfMatch).get(0);
    }

}
