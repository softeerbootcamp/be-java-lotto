package kr.codesquad;

import kr.codesquad.domain.Money;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LottoController lottoController = new LottoController(new InputView(), new OutputView());
        Money money = lottoController.inputMoney();
        lottoController.issueLotto(money);
        lottoController.printResult(lottoController.inputWinningLotto(), money);
    }
}