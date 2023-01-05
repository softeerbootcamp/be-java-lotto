package kr.codesquad.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Result {

    private final Map<Rank, Integer> result = new HashMap<>();

    public Result() {
        Arrays.stream(Rank.values()).forEach(rank -> result.put(rank, 0));
    }

    public Map<Rank, Integer> getResult() {
        return new HashMap<>(result);
    }

    public void addMatchCount(
            Lottos lottos,
            WinLotto winLotto
    ) {
        lottos.getLottoList()
                .stream()
                .map(lotto -> lotto.getRank(winLotto))
                .forEach(rank -> result.put(rank, result.get(rank) + 1));
    }

    public double getProfit() {
        double sum = 0;

        for (Rank rank : Rank.values()) {
            int prizeMoney = rank.getWinningAmount();
            sum += prizeMoney * result.get(rank);
        }

        return sum;
    }

}
