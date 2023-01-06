package kr.codesquad.domain.lotto;

import kr.codesquad.domain.lotto.factory.ManualLottoFactory;
import kr.codesquad.domain.lotto.factory.RandomLottoFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShop {

    private static final int MIN_LOTTO_COUNT = 0;

    public Lottos buyLotto(
            int totalLottoCount,
            int manualLottoCount
    ) {
        int autoLottoCount = totalLottoCount - manualLottoCount;

        Lottos manualLottos = generateManualLotto(manualLottoCount);
        Lottos autoLottos = generateAutoLotto(autoLottoCount);

        return manualLottos.addLottos(autoLottos);
    }

    public Lottos generateManualLotto(int manualLottoCount) {
        List<Lotto> lottoList = IntStream.range(MIN_LOTTO_COUNT, manualLottoCount)
                .mapToObj(i -> new Lotto(new ManualLottoFactory()))
                .collect(Collectors.toList());

        return new Lottos(lottoList);
    }

    public Lottos generateAutoLotto(int autoLottoCount) {
        List<Lotto> lottoList = IntStream.range(MIN_LOTTO_COUNT, autoLottoCount)
                .mapToObj(i -> new Lotto(new RandomLottoFactory()))
                .collect(Collectors.toList());

        return new Lottos(lottoList);
    }
}
