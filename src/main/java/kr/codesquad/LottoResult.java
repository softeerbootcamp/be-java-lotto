package kr.codesquad;

import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> rankStatus;

    private final double rate;

    public LottoResult(Map<Rank, Integer> rankStatus, double rate) {
        this.rankStatus = rankStatus;
        this.rate = rate;
    }

    public Map<Rank, Integer> getRankStatus() {
        return rankStatus;
    }

    public double getRate() {
        return rate;
    }
}
