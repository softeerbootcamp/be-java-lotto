package kr.codesquad.domain;

import java.util.List;

public class LottoGame {
    private final List<Lotto> lottos;

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoResult match(WinningLotto winningLotto){
        LottoResult result = new LottoResult();
        for (Lotto lotto : lottos){
            result.putRank(winningLotto.match(lotto));
        }
        return result;
    }
}