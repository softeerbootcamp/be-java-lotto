package kr.codesquad;

import kr.codesquad.domain.Lotto2;
import kr.codesquad.domain.Money;

import java.util.List;

public class LottoService2 {

    private List<Lotto2> lottos;
    private LottoGenerator lottoGenerator;
    //로또 금액에 맞는 로또 금액 초기화

    public LottoService2(Money money, LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
        this.lottos = lottoGenerator.generate(money);
    }

    //로또 결과를 알려준다.
}
