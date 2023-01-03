package kr.codesquad;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LottoService lottoService = new LottoService(new InputView(), new OutputView(), new Lotto(new NumberGenerator()));
        lottoService.buyLotto();
        lottoService.inputWinningNumber();
        lottoService.calculateTotal();
    }
}