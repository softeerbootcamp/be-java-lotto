package kr.codesquad.domain;

import kr.codesquad.factory.ManualLottoFactory;
import kr.codesquad.factory.RandomLottoFactory;
import kr.codesquad.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos(int amount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottoList.add(new Lotto(new RandomLottoFactory()));
        }
    }

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return new ArrayList<>(lottoList);
    }
}
