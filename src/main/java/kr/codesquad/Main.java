package kr.codesquad;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.WinningLotto;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LottoService lottoService = new LottoService(new InputView(), new OutputView(), new Lotto(new NumberGenerator()));
        lottoService.buyLotto();
        lottoService.inputWinningNumber();
        lottoService.calculateTotal();
    }
}