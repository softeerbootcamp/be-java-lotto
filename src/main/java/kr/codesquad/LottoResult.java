package kr.codesquad;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class LottoResult {
    Map<Rank, Integer> result= new LinkedHashMap<>();

    LottoResult(){
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }
    public void putRank(Rank rank){
        if(!isNull(rank)) result.put(rank, result.get(rank)+1);
    }
    public Money calPrize(){
        int earnMoney = 0;
        for(Rank rank : result.keySet()) {
            earnMoney += rank.getPrize() * result.get(rank);
        }
        return new Money(earnMoney);
    }

}
