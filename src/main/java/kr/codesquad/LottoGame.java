package kr.codesquad;

import kr.codesquad.input.Input;
import kr.codesquad.lotto.Lotto;

import java.util.List;

public class LottoGame {
    private final Input input;

    private final List<Lotto> lottos;

    private LottoGame(Input input) {
        this.input = input;
        lottos = LottoGenerator.of(input.MoneyInput(), input.ManualLottoCountInput()).generateLottos(input);
        for(Lotto lotto : lottos) {
            lotto.fillLottoNumbers();
        }
    }

    public static LottoGame of(Input input) {
        return new LottoGame(input);
    }
}
