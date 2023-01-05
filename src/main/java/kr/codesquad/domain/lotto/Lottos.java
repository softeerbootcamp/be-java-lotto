package kr.codesquad.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
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
