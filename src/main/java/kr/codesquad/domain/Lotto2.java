package kr.codesquad.domain;

import java.util.List;

public class Lotto2 {

    private List<Integer> lottoNumbers;

    public Lotto2(List<Integer> lotto) {
        this.lottoNumbers = lotto;
    }

    public static Lotto2 of(List<Integer> lotto) {
        return new Lotto2(lotto);
    }
}
