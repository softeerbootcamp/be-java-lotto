package kr.codesquad.domain;

import kr.codesquad.util.LottoGenerator;
import kr.codesquad.enums.Rank;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private List<Lotto> lottos;

    public LottoMachine() {
        lottos = new ArrayList<>();
    }
    //로또 금액에 맞는 로또 금액 초기화
    public LottoMachine(Money money, LottoGenerator lottoGenerator) {
        this.lottos = lottoGenerator.generate(money);
    }

    public void issueLotto(Money money, LottoGenerator lottoGenerator) {
        lottos.addAll(lottoGenerator.generate(money));
    }
    //로또 결과를 알려준다.
    public LottoResult calculateResult(WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        //로또 비교 기능
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.compareLotto(lotto);
            lottoResult.increaseCountOfRank(rank);
        }
        return lottoResult;
    }

    public String lottosToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lottos.size(); i++) {
            sb.append("[");
            sb.append(printLotto(lottos.get(i)));
            sb.append("]\n");
        }
        return sb.toString();
    }

    private String printLotto(Lotto lotto) {
        return lotto.toString();
    }
}
