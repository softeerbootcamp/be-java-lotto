package kr.codesquad.lottoStatistic;

import kr.codesquad.Rank;
import kr.codesquad.lotto.Lotto;
import kr.codesquad.lotto.LottoNumber;

import java.util.List;
import java.util.Map;

public class LottoResult {
    private final LottoStatistic lottoStatistic;

    private LottoResult(LottoStatistic lottoStatistic) {
        this.lottoStatistic = lottoStatistic;
    }

    public static LottoResult of(LottoStatistic lottoStatistic) {
        return new LottoResult(lottoStatistic);
    }

    public Map<Rank, Integer> calculate(List<LottoNumber> list, int bonus, List<Lotto> lottos) {
        return this.lottoStatistic.calculateResult(list, bonus, lottos);
    }
}
