package kr.codesquad;

import kr.codesquad.domain.Lotto2;
import kr.codesquad.domain.LottoResult;
import kr.codesquad.domain.Money;
import kr.codesquad.domain.WinningLotto;
import kr.codesquad.enums.Rank2;

import java.util.List;

public class LottoMachine {

    private List<Lotto2> lottos;
    private LottoGenerator lottoGenerator;

    //로또 금액에 맞는 로또 금액 초기화
    public LottoMachine(Money money, LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
        this.lottos = lottoGenerator.generate(money);
    }

    //로또 결과를 알려준다.
    public LottoResult calculateResult(WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        //로또 비교 기능
        for (Lotto2 lotto : lottos) {
            Rank2 rank = winningLotto.compareLotto(lotto);
            lottoResult.increaseCountOfRank(rank);
        }
        return lottoResult;
    }
}
