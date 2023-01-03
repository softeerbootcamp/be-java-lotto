package kr.codesquad;

public enum Rank {
    FIFTH(3, 5000),
    FORTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);
    private int score;
    private int money;
    Rank(int score, int money){
        this.score = score;
        this.money = money;
    }
}
