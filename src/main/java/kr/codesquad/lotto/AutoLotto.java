package kr.codesquad.lotto;

import kr.codesquad.lotto.Lotto;

import java.util.List;

public class AutoLotto extends Lotto {
    public AutoLotto(final List<List<Integer>> lottoList, final Lotto nextLotto) {
        super(lottoList, nextLotto);
    }
}
