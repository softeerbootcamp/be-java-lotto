package kr.codesquad;

import kr.codesquad.sequence.LottosGenerator;

import java.util.List;

public class MyLottoSequence {
    private List<Lotto> lottos;
    private LottosGenerator lottoGenerator;

    public MyLottoSequence(Money money, LottosGenerator lottoGenerator) {
        lottoGenerator.generate(money);
    }
}
