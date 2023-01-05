package kr.codesquad.domain.lotto;

import kr.codesquad.domain.winLotto.WinCount;
import kr.codesquad.domain.winLotto.WinLotto;
import kr.codesquad.domain.winLotto.WinResult;

import java.util.List;
import java.util.Map;

public class LottoService {

    public static final LottoPurchase lottoPurchase = new LottoPurchase();

    public static final WinResult winResult = new WinResult();

    public List<Lotto> buyLotto(int manualAmount, int autoAmount) {
        return lottoPurchase.buyLotto(manualAmount, autoAmount);
    }

    public Map<WinCount, Integer> makeLottoResult(Lottos lottos, WinLotto winLotto) {
        return winResult.makeLottoResult(lottos, winLotto);
    }

}
