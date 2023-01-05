package kr.codesquad.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchase {

    public static final int LOTTO_PRICE = 1000;
    public final LottoAutoFactory lottoAutoFactory = new LottoAutoFactory();

    public final LottoManualFactory lottoManualFactory = new LottoManualFactory();

    public List<Lotto> buyLotto(int manualAmount, int autoAmount) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(lottoManualFactory.buyLotto(manualAmount));
        lottos.addAll(lottoAutoFactory.buyLotto(autoAmount));
        return lottos;
    }

}
