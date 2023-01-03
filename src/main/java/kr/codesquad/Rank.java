package kr.codesquad;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private  final int cnt;
    private  final int prize;

    Rank(int cnt, int prize) {
        this.cnt = cnt;
        this.prize = prize;
    }
    public int getCnt(){
        return cnt;
    }
    public int getPrize(){
        return prize;
    }
    public static Rank valueOf(int cnt, boolean bonus) {
        if(cnt < 3) return null;
        Rank[] ranks = values();
        Rank value = null;
        for (Rank rank : ranks) {
            value = ranking(rank, cnt, bonus);
        }

        return value;
    }
    public static Rank ranking(Rank rank, int cnt, boolean bonus){
        if (cnt == SECOND.cnt) {
            return bonus ? SECOND : THIRD;
        }
        if (rank.cnt == cnt) {
            return rank;
        }
        return null;
    }
}
