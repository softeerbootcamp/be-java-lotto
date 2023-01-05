package kr.codesquad;

import java.util.List;

public abstract class Lotto {
    private final List<List<Integer>> lottoList;
    private final Lotto nextLotto;

    public Lotto(List<List<Integer>> lottoList, Lotto nextLotto) {
        this.lottoList = lottoList;
        this.nextLotto = nextLotto;
    }

    public List<List<Integer>> getLottoList() {
        lottoList.addAll(nextLotto.getLottoList());
        return lottoList;
    }
}