package kr.codesquad.domain;

import kr.codesquad.domain.lotto.Lottos;
import kr.codesquad.domain.lotto.WinLotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Result {

    private static final int DEFAULT_SUM = 0;

    private static final int DEFAULT_COUNT = 0;

    private final Map<Rank, Integer> result = new HashMap<>();

    public Result() {
        Arrays.stream(Rank.values()).forEach(rank -> result.put(rank, DEFAULT_COUNT));
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
        double sum = DEFAULT_SUM;

        for (Rank rank : Rank.values()) {
            int prizeMoney = rank.getWinningAmount();
            sum += prizeMoney * result.get(rank);
        }

        return sum;
    }

}
