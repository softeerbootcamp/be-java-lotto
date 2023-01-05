package kr.codesquad.LottoService;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<Rank, Integer> result = new HashMap<>();
    public LottoResult(){
        for (Rank value : Rank.values()){
            result.put(value, 0);
        }
    }

    public void putRank(Rank rank){
        result.put(rank, result.get(rank) + 1);}

    public Integer getValue(Rank rank) {
        return result.get(rank);
    }

    public Integer getPrize(){
        int totalPrize = 0;
        for (Rank rank : result.keySet()){
            totalPrize += rank.prize(result.get(rank));
        }
        return totalPrize;
    }

    public void printResult(){
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        for (Rank rank : Rank.values()){
            if (rank == Rank.MISS) continue;
            System.out.print(rank.getCountOfMatch() + "개 일치");
            if (rank == Rank.SECOND) System.out.print(", 보너스 볼 일치");
            System.out.printf(" (%d원)- %d개\n",rank.getWinningMoney(), result.get(rank));
        }
    }
}

