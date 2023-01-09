package kr.codesquad.domain.lotto;

import kr.codesquad.domain.other.Amount;
import kr.codesquad.domain.other.Bonus;
import kr.codesquad.domain.winLotto.WinLotto;

import java.util.List;

public class LottoService {

    public static final LottoPurchase lottoPurchase = new LottoPurchase();

    public List<Lotto> buyLotto(int manualAmount, int autoAmount) {
        return lottoPurchase.buyLotto(manualAmount, autoAmount);
    }

    public Lotto makeLotto(List<Integer> lottoNum) {
        return new Lotto(lottoNum);
    }

    public Bonus makeBonus(int bonusNum, Lotto lotto) {
        return new Bonus(bonusNum, lotto);
    }

    public Amount makeAmount(int amount) {
        return new Amount(amount);
    }

    public Amount makeAmount(Amount totalAmount, int amount) {
        return new Amount(totalAmount, amount);
    }

    public WinLotto makeWinLotto(Lotto winLotto, Bonus bonus) {
        return new WinLotto(winLotto, bonus);
    }
}
