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
        List<Lotto> lottos = buyLotto(money);
        console.printLottoNum(lottos);

        WinLotto winLotto = inputWinLotto();
        Map<WinCount, Integer> lottoResult = lottoService.makeLottoResult(lottos, winLotto);
        console.printLottoResult(money, lottoResult);
    }

    private List<Lotto> buyLotto(int money) {
        int manualAmount = console.inputManualLottoAmount();
        int autoAmount = money / LOTTO_PRICE - manualAmount;
        console.printAmount(manualAmount, autoAmount);
        return lottoService.buyLotto(manualAmount, autoAmount);
    }

    private WinLotto inputWinLotto() {
        Lotto winNum = console.inputWinNum();
        int bonusNum = console.inputBonusNum();
        return new WinLotto(winNum, bonusNum);
    }

}
