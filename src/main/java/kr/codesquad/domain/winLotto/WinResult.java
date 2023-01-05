package kr.codesquad.domain.winLotto;

import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.domain.lotto.Lottos;
import kr.codesquad.domain.other.Money;

import java.util.*;
import java.util.stream.Collectors;

public class WinResult {

    public final Map<WinCount, Integer> winResultMap;

    private WinResult() {
        this.winResultMap = Arrays.stream(WinCount.values())
                .collect(Collectors.toMap(w -> w, w -> 0, (a, b) -> b));
    }

    public static WinResult createWinResult(
            Lottos lottos,
            WinLotto winLotto
    ) {
        WinResult winResult = new WinResult();
        winResult.calWinResult(lottos, winLotto);
        return winResult;
    }

    private void calWinResult(
            Lottos lottos,
            WinLotto winLotto
    ) {
        lottos.getLottos().stream()
                .map(winLotto::findWinningCount)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(winResultMap::containsKey)
                .forEach(winCount -> winResultMap.put(winCount, winResultMap.get(winCount) + 1));
    }

    public void printWinResultSentence() {
        Arrays.stream(WinCount.values())
                .forEach(winCount -> {
                    System.out.println(getWinCountSentence(winCount));
                });
    }

    public String getWinCountSentence(WinCount winCount) {
        String bonus = (winCount.getIsBonus()) ? ", 보너스 볼 일치" : "";
        return winCount.getCount() + "개 일치" + bonus + "(" + winCount.getPrice() + ")원 - " + winResultMap.get(winCount) + "개";
    }

    public void printProfit(Money money) {
        int rewardSum = winResultMap
                .entrySet()
                .stream()
                .mapToInt(lotto -> lotto.getKey().getPrice() * lotto.getValue())
                .sum();

        double ans = (((double) (rewardSum - money.getMoney())) / (double) money.getMoney()) * 100.0;
        System.out.println("총 수익률은 " + Math.floor(ans * 100) / 100.0 + "%입니다.");
    }

}
