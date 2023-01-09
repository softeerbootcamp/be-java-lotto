package kr.codesquad.lotto;

import kr.codesquad.lotto.Lotto;

import java.util.List;

public class ManualLotto extends Lotto {
    public ManualLotto(final List<List<Integer>> lottoList, final Lotto nextLotto) {
        super(lottoList, nextLotto);
    }
}
