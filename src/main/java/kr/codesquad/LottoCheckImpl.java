package kr.codesquad;

import java.util.List;

public class LottoCheckImpl implements LottoCheck {
	@Override
	public LottoResult checkLotto(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
		LottoResult lottoResult = new LottoResult();
		for (Lotto lotto : purchasedLottos) {
			compareEachLotto(lotto, winningLotto, lottoResult);
		}

		return lottoResult;
	}

	public void compareEachLotto(Lotto purchasedLotto, WinningLotto winningLotto, LottoResult lottoResult) {
		LottoMatchType lottoMatchType = winningLotto.matchLotto(purchasedLotto);
		lottoResult.updateResult(lottoMatchType.getMatchCount(), 1);
	}
}
