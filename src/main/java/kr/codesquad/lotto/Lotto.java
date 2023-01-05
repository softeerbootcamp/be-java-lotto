package kr.codesquad.lotto;

import kr.codesquad.input.Input;

import java.util.ArrayList;
import java.util.List;

public abstract class Lotto {
    private final Input input;

    public static int PRICE = 1000;

    public static int NUMBER_COUNT = 6;

    private List<LottoNumber> lottoNumbers;

    public Lotto(Input input) {
        lottoNumbers = new ArrayList<>();
        this.input = input;
    }

    abstract public Lotto fillLottoNumbers();
}
