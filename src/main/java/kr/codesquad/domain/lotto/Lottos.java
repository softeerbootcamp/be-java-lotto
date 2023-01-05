package kr.codesquad.domain.lotto;

import kr.codesquad.domain.lotto.factory.RandomLottoFactory;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos (List<Lotto> lottoList) {
        this.lottoList = new ArrayList<>(lottoList);
    }

    public Lottos(int totalLottoCount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < totalLottoCount; i++) {
            lottoList.add(new Lotto(new RandomLottoFactory()));
        }
    }

    public Lottos addLottos(Lottos lottosBeCombined) {
        this.lottoList.addAll(lottosBeCombined.lottoList);
        return this;
    }

    public List<Lotto> getLottoList() {
        return new ArrayList<>(lottoList);
    }
}
