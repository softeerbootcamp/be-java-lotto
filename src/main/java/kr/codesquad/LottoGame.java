package kr.codesquad;

import kr.codesquad.IO.Input;
import kr.codesquad.IO.Output;
import kr.codesquad.lotto.Lotto;
import kr.codesquad.lotto.WinningLotto;
import kr.codesquad.lottoGeneration.LottoGenerator;
import kr.codesquad.lottoStatistic.StatisticImpl;

import java.util.List;
import java.util.Map;

public class LottoGame {
    private final Input input;

    private final Output output;


    private LottoGame(Input input, Output output) {
        this.input = input;
        this.output = output;

        int money = this.input.moneyInput();
        int manualCount = this.input.manualLottoCountInput();

        List<Lotto> lottos = new LottoGenerator().generate(money, manualCount);

        output.generatedLottoResultOutput(manualCount, money/Lotto.PRICE, lottos);

        WinningLotto winningLotto = WinningLotto.of(input.jackpotNumberInput(), input.bonusNumberInput());

        Map<Rank, Integer> lottoResult = winningLotto.getLottoResult(lottos);

        output.lottoResultOutput(lottoResult);

        output.lottoProfitOutput(new StatisticImpl(), money, lottoResult);
    }



    public static LottoGame of(Input input, Output output) {
        return new LottoGame(input, output);
    }
}