package kr.codesquad;

import java.util.HashMap;
import java.util.Map;

public enum Rank{
    FIFTH(3, 5000),
    FORTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);
    private int score;
    private int money;
    private static final Map<Integer, Rank> RANK_CASH = new HashMap<>();
    static {
        for (Rank rank : values()) {
            RANK_CASH.put(rank.score, rank);
        }
    }
    Rank(int score, int money){
        this.score = score;
        this.money = money;
    }
    
    public int getScore() {
        return score;
    }

    public int getMoney() {
        return money;
    }
    public static Rank getRankByScore(int score) {
        return RANK_CASH.get(score);
    }
}
