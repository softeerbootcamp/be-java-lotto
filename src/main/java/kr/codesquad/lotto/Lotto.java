package kr.codesquad.lotto;

import kr.codesquad.input.Input;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static int PRICE = 1000;

    public static int NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> list) {
        lottoNumbers = list;
    }
}
