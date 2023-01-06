package kr.codesquad.lotto;

import kr.codesquad.lotto.io.LottoIOManager;

import java.util.List;

public class LottoMachine {

    private final LottoIOManager lottoIOManager;
    private final LottosGenerator lottosGenerator;

    public LottoMachine(
            LottosGenerator lottosGenerator,
            LottoIOManager lottoIOManager
    ) {
        this.lottosGenerator = lottosGenerator;
        this.lottoIOManager = lottoIOManager;
    }

    public LottoTicket buy() {
        int money = lottoIOManager.readPurchasePrice();
        List<Lotto> lottos = this.lottosGenerator.generator(money);
        return new LottoTicket(lottos, money);
    }

    public LottoResult check(LottoTicket lottoTicket) {
        WinningLotto winningLotto = lottoIOManager.readWinningLottoNumber();
        return lottoTicket.match(winningLotto);
    }
}
