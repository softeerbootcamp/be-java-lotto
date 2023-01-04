package kr.codesquad.lotto;

import kr.codesquad.winLotto.WinCount;
import kr.codesquad.winLotto.WinLotto;
import kr.codesquad.winLotto.WinResult;

import java.util.List;
import java.util.Map;

public class LottoService {

    public static final LottoPurchase lottoPurchase = new LottoPurchase();

    public static final WinResult winResult = new WinResult();

    public List<Lotto> buyLotto(int money) {
        return lottoPurchase.buyLotto(money);
    }

    public Map<WinCount, Integer> makeLottoResult(List<Lotto> lottoList, WinLotto winLotto) {
        return winResult.makeLottoResult(lottoList, winLotto);
    }

}
