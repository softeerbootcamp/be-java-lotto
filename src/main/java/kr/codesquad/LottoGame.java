package kr.codesquad;

import kr.codesquad.input.Input;
import kr.codesquad.lotto.Lotto;
import kr.codesquad.lottoGeneration.LottoGenerator;
import kr.codesquad.lottoStatistic.LottoResult;
import kr.codesquad.lottoStatistic.LottoStatisticImpl;

import java.util.List;
import java.util.Map;

public class LottoGame {
    private final Input input;

    private final List<Lotto> lottos;

    private LottoGame(Input input) {
        this.input = input;
        lottos = LottoGenerator.of(input.moneyInput(), input.manualLottoCountInput()).generateLottos(input);
        Map<Rank, Integer> lottoResult = LottoResult.of(new LottoStatisticImpl()).calculate(input.jackpotNumberInput()
                , input.bonusNumberInput(), lottos);
    }

    public static LottoGame of(Input input) {
        return new LottoGame(input);
    }
}
