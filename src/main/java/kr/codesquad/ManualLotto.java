package kr.codesquad;

import java.util.List;

public class ManualLotto extends Lotto {
    public ManualLotto(final List<List<Integer>> lottoList, final Lotto nextLotto) {
        super(lottoList, nextLotto);
    }
}
