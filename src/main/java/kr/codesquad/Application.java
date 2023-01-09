package kr.codesquad;

import kr.codesquad.domain.other.Amount;
import kr.codesquad.domain.other.Bonus;
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

        WinLotto winLotto = inputWinLotto();
        WinResult winResult = WinResult.createWinResult(lottos, winLotto);
        console.printLottoResult(money, winResult);
    }

    private Lottos buyLotto(Money money) {
        Amount totalAmount = lottoService.makeAmount(money.getMoney() / LottoUtil.LOTTO_PRICE);
        Amount manualAmount = lottoService.makeAmount(totalAmount, console.inputManualLottoAmount());
        Amount autoAmount = lottoService.makeAmount(totalAmount.getAmount() - manualAmount.getAmount());
        List<Lotto> lottos = lottoService.buyLotto(manualAmount.getAmount(), autoAmount.getAmount());

        console.printLottoNum(lottos);
        console.printAmount(manualAmount.getAmount(), autoAmount.getAmount());
        return new Lottos(lottos);
    }

    private WinLotto inputWinLotto() {
        Lotto lotto = lottoService.makeLotto(console.inputWinLottoNum());
        Bonus bonusNum = lottoService.makeBonus(console.inputBonusNum(), lotto);

        return lottoService.makeWinLotto(lotto, bonusNum);
    }


}
