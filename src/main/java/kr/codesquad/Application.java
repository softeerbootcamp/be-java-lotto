package kr.codesquad;

import kr.codesquad.io.Console;
import kr.codesquad.lotto.Lotto;
import kr.codesquad.lotto.LottoService;
import kr.codesquad.lotto.Lottos;
import kr.codesquad.winLotto.WinCount;
import kr.codesquad.winLotto.WinLotto;

import java.util.List;
import java.util.Map;

public class Application {

    private final Console console;

    private final LottoService lottoService;

    Application(
            Console console,
            LottoService lottoService
    ) {
        this.console = console;
        this.lottoService = lottoService;
    }

    public void start() {
        int money = console.inputMoney();
        Lottos lottos = new Lottos(buyLotto(money));

        WinLotto winLotto = inputWinLotto();
        Map<WinCount, Integer> lottoResult = lottoService.makeLottoResult(lottos, winLotto);
        console.printLottoResult(money, lottoResult);
    }

    private List<Lotto> buyLotto(int money) {
        int manualAmount = console.inputManualLottoAmount();
        int autoAmount = money / Lotto.LOTTO_PRICE - manualAmount;
        List<Lotto> lottos = lottoService.buyLotto(manualAmount, autoAmount);

        console.printLottoNum(lottos);
        console.printAmount(manualAmount, autoAmount);
        return lottos;
    }

    private WinLotto inputWinLotto() {
        return new WinLotto(console.inputWinLottoNum(), console.inputBonusNum());
    }

}
