package kr.codesquad.lotto;

import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoList;
    private final int money;

    public LottoTicket(List<Lotto> lottoList, int money) {
        this.lottoList = lottoList;
        this.money = money;
    }

    public LottoResult match(WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult(money);

        for (Lotto lotto: lottoList) {
            lottoResult.putRank(winningLotto.match(lotto));
        }

        return lottoResult;
    }
}
