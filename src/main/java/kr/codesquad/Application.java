package kr.codesquad;

import kr.codesquad.io.Console;
import kr.codesquad.lotto.Lotto;
import kr.codesquad.lotto.LottoService;
import kr.codesquad.winLotto.WinCount;
import kr.codesquad.winLotto.WinLotto;

import java.util.List;
import java.util.Map;

public class Application {

    public static final int LOTTO_PRICE = 1000;
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
        int lottoAmount = money / LOTTO_PRICE;
        console.printAmount(lottoAmount);
        List<Lotto> allLotto = lottoService.makeLottoList(lottoAmount);
        console.printLottoNum(allLotto);
        WinLotto winLotto = new WinLotto(console.inputWinNum(), console.inputBonusNum());
        Map<WinCount, Integer> lottoResult = lottoService.makeLottoResult(allLotto, winLotto);
        console.printLottoResult(money, lottoResult);
    }

}
