package kr.codesquad.lottoStatistic;

import kr.codesquad.Rank;
import kr.codesquad.lotto.Lotto;
import kr.codesquad.lotto.LottoNumber;

import java.util.List;
import java.util.Map;

public interface LottoStatistic {
    Map<Rank, Integer> calculateResult(List<LottoNumber> list, int bonus, List<Lotto> lottos);
}
