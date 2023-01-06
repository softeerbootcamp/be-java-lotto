package kr.codesquad.IO;

import kr.codesquad.Rank;
import kr.codesquad.lotto.Lotto;
import kr.codesquad.lottoStatistic.Statistic;

import java.util.List;
import java.util.Map;

public class OutputImpl implements Output {
    @Override
    public void generatedLottoResultOutput(int manualCount, int total, List<Lotto> lottos) {
        System.out.println("수동으로 "  + manualCount + "개, 자동으로 " + (total - manualCount) + "개 구매했습니다");
        printLottos(lottos);
    }

    @Override
    public void lottoResultOutput(Map<Rank, Integer> result) {
        System.out.println("당첨 통계\n---------------");
        for(Rank rank : Rank.values()) {
            if(rank != Rank.MISS) {
                System.out.println(generateResultString(result, rank));
            }
        }
    }

    @Override
    public void lottoProfitOutput(Statistic statistic, int money, Map<Rank, Integer> result) {
        System.out.println("수익률은 " + String.format("%.2f", statistic.countProfit(money, result)) + "%입니다");
    }

    private void printLottos(List<Lotto> lottos) {
        for(Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    private String generateResultString(Map<Rank, Integer> result, Rank rank) {
        String bonusString = rank == Rank.SECOND ? ", 보너스 볼 일치" : "";
        String defaultString = rank.getCountOfMatch() + "개 일치"
                + bonusString
                + "(" + rank.getWinningMoney() + ") - " + result.get(rank) + "개";

        return defaultString;
    }
}