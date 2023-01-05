package kr.codesquad.domain.lotto;

import kr.codesquad.domain.lotto.factory.ManualLottoFactory;
import kr.codesquad.domain.lotto.factory.RandomLottoFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShop {

    private static final int LOTTO_PRICE = 1000;
    public Lottos buyLotto(
            int money,
            int manualLottoCount
    ) {
        int totalLottoCount = money / LOTTO_PRICE;
        int autoLottoCount = totalLottoCount - manualLottoCount;

        Lottos manualLottos = generateManualLotto(manualLottoCount);
        Lottos autoLottos = generateAutoLotto(autoLottoCount);

        return manualLottos.addLottos(autoLottos);
    }

    private Lottos generateManualLotto(int manualLottoCount) {
        List<Lotto> lottoList = IntStream.range(0, manualLottoCount)
                .mapToObj(i -> new Lotto(new ManualLottoFactory()))
                .collect(Collectors.toList());

        return new Lottos(lottoList);
    }

    private Lottos generateAutoLotto(int autoLottoCount) {
        List<Lotto> lottoList = IntStream.range(0, autoLottoCount)
                .mapToObj(i -> new Lotto(new RandomLottoFactory()))
                .collect(Collectors.toList());

        return new Lottos(lottoList);
    }
}
