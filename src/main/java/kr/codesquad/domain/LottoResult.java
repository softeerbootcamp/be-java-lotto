package kr.codesquad.domain;


import kr.codesquad.enums.Rank2;

import java.util.Map;

public class LottoResult {
    private Map<Rank2, Integer> resultMap;

    public LottoResult() {
        for (Rank2 value : Rank2.values()) {
            resultMap.put(value, 0);
        }
    }

    public void increaseCountOfRank(Rank2 rank) {
        resultMap.put(rank, resultMap.get(rank) + 1);
    }
}
