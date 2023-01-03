package kr.codesquad;

import kr.codesquad.LottoService.Lotto;
import kr.codesquad.LottoService.LottoService;

public class App {
    private final Console console;
    private final LottoService lottoService;

    public App(Console console, LottoService lottoService) {
        this.console = console;
        this.lottoService = lottoService;
    }

    public void run() {
        console.inputMoney();
        console.printLottoCount();
        lottoService.setLottoNumbers(console.getLottoCount());
        lottoService.printLottos();

        console.inputWinningNumber();
        console.inputBonusNumber();
        lottoService.setWinningNumbers(console.getWinningNumberList(), console.getBonusNumber());
        lottoService.printWinningLottos();
        lottoService.calculateEarningRate(console.getLottoCount());
    }
}
