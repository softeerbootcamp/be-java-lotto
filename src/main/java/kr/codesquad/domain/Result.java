package kr.codesquad.domain;

import java.util.*;
public class Result {

    private final Map<Rank, Integer> result = new HashMap<>();

    public Result() {
        Arrays.stream(Rank.values()).forEach(rank -> result.put(rank, 0));
    }

    public Map<Rank, Integer> getResult() {
        return new HashMap<>(result);
    }

    public void addMatchCount(Lottos lottos, WinLotto winLotto) {
        for (Lotto lotto : lottos.getLottoList()) {
            Rank rank = lotto.getRank(winLotto);
            result.put(rank, result.get(rank) + 1);
        }
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
