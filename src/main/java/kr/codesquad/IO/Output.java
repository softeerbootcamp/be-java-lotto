package kr.codesquad.IO;

import kr.codesquad.Rank;
import kr.codesquad.lotto.Lotto;
import kr.codesquad.lottoStatistic.Statistic;

import java.util.List;
import java.util.Map;

public interface Output {
    void generatedLottoResultOutput(int manualCount, int total, List<Lotto> lottos);

    void lottoResultOutput(Map<Rank, Integer> result);

    void lottoProfitOutput(Statistic statistic, int money, Map<Rank, Integer> result);
}
