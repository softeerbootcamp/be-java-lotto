package kr.codesquad.controller;

import kr.codesquad.model.Lotto;
import kr.codesquad.model.LottoMachine;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.util.List;

public class LottoController {

    private final LottoMachine lottoMachine;

    public LottoController() {
        this.lottoMachine = new LottoMachine();
    }

    public void start() {
        OutputView.printMoneyReadMessage();
        int money = InputView.readMoney();

        int lottoCount = money / 1000;
        OutputView.printLottoCount(lottoCount);

        List<Lotto> lottos = lottoMachine.createLottos(lottoCount);

        OutputView.printLottos(lottos);

        OutputView.printWinningLottoReadMessage();
    }
}
