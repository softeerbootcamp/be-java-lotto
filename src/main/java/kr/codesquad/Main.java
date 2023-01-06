package kr.codesquad;

import kr.codesquad.controller.LottoController;
import kr.codesquad.domain.LottoMachine;
import kr.codesquad.domain.Money;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LottoController lottoController = new LottoController(new InputView(), new OutputView(), new LottoMachine());
        Money money = lottoController.inputMoney();
        Money manualLottoMoney = lottoController.issueManualLotto(money);
        lottoController.issueLotto(money, manualLottoMoney);
        lottoController.printResult(lottoController.inputWinningLotto(), money.sum(manualLottoMoney));
    }
}