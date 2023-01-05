package kr.codesquad;

import kr.codesquad.io.Console;
import kr.codesquad.lotto.Lotto;
import kr.codesquad.lotto.LottoService;
import kr.codesquad.winLotto.WinCount;
import kr.codesquad.winLotto.WinLotto;

import java.util.List;
import java.util.Map;

public class Application {

    private final Console console;

    private final LottoService lottoService;

    public static final int LOTTO_PRICE = 1000;
    Application(
            Console console,
            LottoService lottoService
    ) {
        this.console = console;
        this.lottoService = lottoService;
    }

    public void start() {
        int money = console.inputMoney();
        int manualAmount = console.inputManualLottoAmount();
        int autoAmount = money / LOTTO_PRICE - manualAmount;
        List<Lotto> lottos = lottoService.buyLotto(manualAmount, autoAmount);
        console.printAmount(manualAmount, autoAmount);
        console.printLottoNum(lottos);
        WinLotto winLotto = new WinLotto(console.inputWinNum(), console.inputBonusNum());
        Map<WinCount, Integer> lottoResult = lottoService.makeLottoResult(lottos, winLotto);
        console.printLottoResult(money, lottoResult);
    }

}
