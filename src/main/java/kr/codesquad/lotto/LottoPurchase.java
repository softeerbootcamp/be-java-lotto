package kr.codesquad.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchase {

    public static final int LOTTO_PRICE = 1000;
    public final  LottoAutoFactory lottoAutoFactory = new LottoAutoFactory();

    public final LottoManualFactory lottoManualFactory = new LottoManualFactory();

    public List<Lotto> buyLotto(int amount , List<Lotto> lottos) {
        for (int i = 0; i < amount; i++) {
            Lotto lotto = lottoAutoFactory.makeLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

}
