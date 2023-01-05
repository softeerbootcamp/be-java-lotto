package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottoList;

    public Lottos(int amount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottoList.add(new Lotto());
        }
    }

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return new ArrayList<>(lottoList);
    }
}
