package kr.codesquad;

import kr.codesquad.LottoService.LottoStore;
import kr.codesquad.View.Console;

public class App {
    private final Console console;
    private final LottoStore lottoStore;

    public App(Console console, LottoStore lottoStore) {
        this.console = console;
        this.lottoStore = lottoStore;
    }

    public void run() throws Exception {
        console.inputMoney();
        console.printLottoCount();
        lottoStore.setAutomaticLotto(console.getLottoCount());
        console.printLottoList(lottoStore.getLottoList());

        console.inputWinningNumber();
        console.inputBonusNumber();
        lottoStore.setWinningNumbers(console.getWinningNumberList(), console.getBonusNumber());
        console.printWinningLottoMap(lottoStore.getwinningLottoMap());
        lottoStore.calculateEarningRate(console.getLottoCount());
    }
}
