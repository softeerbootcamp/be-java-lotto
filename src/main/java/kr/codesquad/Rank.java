package kr.codesquad;

import static java.util.Objects.isNull;

public enum Rank {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);
    private  final int cnt;
    private  final int prize;
    Rank(int cnt, int prize) {
        this.cnt = cnt;
        this.prize = prize;
    }
    public int getPrize(){
        return prize;
    }
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
    @Override
    public String toString(){
        if(this == SECOND) return this.cnt + "개 일치, 보너스 볼 일치" + "(" + this.prize + "원)";
        return this.cnt + "개 일치" + "(" + this.prize + "원)";
    }
}
