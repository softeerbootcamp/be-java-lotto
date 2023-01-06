package kr.codesquad.lottoGeneration;

import kr.codesquad.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoGenerator {
    public LottoGenerator() {}

    public List<Lotto> generate(int money, int manualCount) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(Objects.requireNonNull(generateLotto(manualCount, new ManualLottoFactory())));
        lottos.addAll(Objects.requireNonNull(generateLotto(money / Lotto.PRICE - manualCount, new AutoLottoFactory())));

        return lottos;
    }

    private List<Lotto> generateLotto(int count, LottoFactory lottoFactory) {
        return lottoFactory.generate(count);
    }
}

