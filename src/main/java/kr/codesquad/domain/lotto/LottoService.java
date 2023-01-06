package kr.codesquad.domain.lotto;

import kr.codesquad.domain.other.Bonus;
import kr.codesquad.domain.winLotto.WinLotto;

import java.util.List;

public class LottoService {

    public static final LottoPurchase lottoPurchase = new LottoPurchase();

    public List<Lotto> buyLotto(int manualAmount, int autoAmount) {
        return lottoPurchase.buyLotto(manualAmount, autoAmount);
    }

    public WinLotto makeWinLotto(Lotto winLotto, Bonus bonus) {
        return new WinLotto(winLotto, bonus);
    }
}
