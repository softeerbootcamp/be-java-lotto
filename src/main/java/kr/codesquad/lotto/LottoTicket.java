package kr.codesquad.lotto;

import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottos;
    private final int money;

    public LottoTicket(List<Lotto> lottos, int money) {
        this.lottos = lottos;
        this.money = money;
    }

    public LottoResult match(WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult(money);

        for (Lotto lotto: lottos) {
            lottoResult.putRank(winningLotto.match(lotto));
        }

        return lottoResult;
    }
}
