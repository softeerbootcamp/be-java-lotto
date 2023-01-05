package kr.codesquad.LottoService;

import kr.codesquad.Rank;

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
}

