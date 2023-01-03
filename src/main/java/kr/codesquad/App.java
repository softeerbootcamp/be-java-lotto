package kr.codesquad;

import kr.codesquad.LottoService.LottoStore;

public class App {
    private final Console console;
    private final LottoStore lottoStore;

    public App(Console console, LottoStore lottoStore) {
        this.console = console;
        this.lottoStore = lottoStore;
    }

    public void run() {
        console.inputMoney();
        console.printLottoCount();
        lottoStore.setAutomaticLotto(console.getLottoCount());
        console.printLottos(lottoStore.getLottos());

        console.inputWinningNumber();
        console.inputBonusNumber();
        lottoStore.setWinningNumbers(console.getWinningNumberList(), console.getBonusNumber());
        console.printWinningLottos(lottoStore.getWinningLottos());
        lottoStore.calculateEarningRate(console.getLottoCount());
    }
}
