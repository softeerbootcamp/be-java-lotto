package kr.codesquad;

import static java.util.Objects.isNull;

public enum Rank {
    FIRST(6, 2000000000, "6개 일치"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 1500000, "5개 일치"),
    FOURTH(4, 50000, "4개 일치"),
    FIFTH(3, 5000, "3개 일치");

    private  final int cnt;
    private  final int prize;
    private final String words;

    Rank(int cnt, int prize, String words) {
        this.cnt = cnt;
        this.prize = prize;
        this.words = words;
    }
    public int getCnt(){
        return cnt;
    }
    public int getPrize(){
        return prize;
    }
    public String getWords(){ return words; }
    public static Rank valueOf(int cnt, boolean bonus) {
        Rank[] ranks = values();
        Rank value = null;
        for (Rank rank : ranks) {
            value = ranking(rank, value, cnt, bonus);
        }
        return value;
    }
    public static Rank ranking(Rank rank, Rank value, int cnt, boolean bonus){
        if(!isNull(value)) {
            return value;
        }
        if (cnt == SECOND.cnt) {
            return bonus ? SECOND : THIRD;
        }
        if (rank.cnt == cnt) {
            return rank;
        }
        return null;
    }
}
