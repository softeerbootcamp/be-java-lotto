package kr.codesquad.controller;

import kr.codesquad.model.Lotto;
import kr.codesquad.model.LottoMachine;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.util.List;

public class LottoController {

    public void start() {
        OutputView.printStartMessage();
        int money = InputView.readMoney();

        int lottoCount = money / 1000;
        OutputView.printLottoCount(lottoCount);

        List<Lotto> lottos = LottoMachine.createLottos(lottoCount);
    }
}
