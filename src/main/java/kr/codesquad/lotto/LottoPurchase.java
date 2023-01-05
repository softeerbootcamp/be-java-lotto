package kr.codesquad.lotto;

import kr.codesquad.lotto.factory.LottoAutoFactory;
import kr.codesquad.lotto.factory.LottoFactory;
import kr.codesquad.lotto.factory.LottoManualFactory;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchase {

    public final LottoFactory lottoAutoFactory = new LottoAutoFactory();

    public final LottoFactory lottoManualFactory = new LottoManualFactory();

    public List<Lotto> buyLotto(int manualAmount, int autoAmount) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(lottoManualFactory.buyLotto(manualAmount));
        lottos.addAll(lottoAutoFactory.buyLotto(autoAmount));
        return lottos;
    }

}
