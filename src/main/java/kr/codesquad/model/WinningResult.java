package kr.codesquad.model;

import java.util.Map;

public class WinningResult {

    private final Map<Rank, Integer> result;

    public WinningResult(Map<Rank, Integer> result) {
        this.result = result;
    }

    public double calculateProfitRate(int money) {
        double profit = result.entrySet()
                .stream()
                .map(entry ->
                        entry.getKey().getPrize() * entry.getValue())
                .reduce(0, Integer::sum);

        return (profit - money) / money * 100;
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }
}
