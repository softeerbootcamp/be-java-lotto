package kr.codesquad;

import kr.codesquad.domain.other.Money;
import kr.codesquad.domain.winLotto.WinResult;
import kr.codesquad.io.Console;
import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.domain.lotto.LottoService;
import kr.codesquad.domain.lotto.Lottos;
import kr.codesquad.util.LottoUtil;
import kr.codesquad.domain.winLotto.WinCount;
import kr.codesquad.domain.winLotto.WinLotto;

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
        Money money = console.inputMoney();
        Lottos lottos = buyLotto(money);

        WinLotto winLotto = lottoService.makeWinLotto(console.inputWinLottoNum(), console.inputBonusNum());
        WinResult winResult = WinResult.createWinResult(lottos, winLotto);
        console.printLottoResult(money, winResult);
    }

    private Lottos buyLotto(Money money) {
        int manualAmount = console.inputManualLottoAmount();
        int autoAmount = money.getMoney() / LottoUtil.LOTTO_PRICE - manualAmount;
        List<Lotto> lottos = lottoService.buyLotto(manualAmount, autoAmount);

        console.printLottoNum(lottos);
        console.printAmount(manualAmount, autoAmount);
        return new Lottos(lottos);
    }


}
