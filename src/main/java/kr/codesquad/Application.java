package kr.codesquad;

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
        int money = console.inputMoney();
        Lottos lottos = new Lottos(buyLotto(money));

        WinLotto winLotto = new WinLotto(console.inputWinLottoNum(), console.inputBonusNum());
        Map<WinCount, Integer> lottoResult = lottoService.makeLottoResult(lottos, winLotto);
        console.printLottoResult(money, lottoResult);
    }

    private List<Lotto> buyLotto(int money) {
        int manualAmount = console.inputManualLottoAmount();
        int autoAmount = money / LottoUtil.LOTTO_PRICE - manualAmount;
        List<Lotto> lottos = lottoService.buyLotto(manualAmount, autoAmount);

        console.printLottoNum(lottos);
        console.printAmount(manualAmount, autoAmount);
        return lottos;
    }


}
