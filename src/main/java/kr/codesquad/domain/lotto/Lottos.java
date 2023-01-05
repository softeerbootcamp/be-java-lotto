package kr.codesquad.domain.lotto;

import kr.codesquad.domain.lotto.factory.RandomLottoFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {

    private static final int MIN_LOTTO_COUNT = 0;
    private final List<Lotto> lottoList;

    public Lottos (List<Lotto> lottoList) {
        this.lottoList = new ArrayList<>(lottoList);
    }

    public Lottos addLottos(Lottos lottosBeCombined) {
        this.lottoList.addAll(lottosBeCombined.lottoList);
        return this;
    }

    public List<Lotto> getLottoList() {
        return new ArrayList<>(lottoList);
    }
}
