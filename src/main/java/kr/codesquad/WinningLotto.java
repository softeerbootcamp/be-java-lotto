package kr.codesquad;

public class WinningLotto {

	private Lotto winningLotto;
	private LottoNumber bonusBall;

	private WinningLotto(Lotto lotto, LottoNumber bonusBall) {
		this.winningLotto = lotto;
		this.bonusBall = bonusBall;
	}

	public static WinningLotto of(Lotto lotto, int bonusBall) {
		return new WinningLotto(lotto, LottoNumber.of(bonusBall));
	}

	public LottoMatchType matchLotto(Lotto lotto) {
		int match = winningLotto.match(lotto);

		LottoMatchType lottoMatchType = LottoMatchType.getLottoMatchTypeByMatchCount(
			match);
		if (lotto.increment(bonusBall) == 1 && lottoMatchType == LottoMatchType.FIVE_MATCH) {
			return LottoMatchType.BONUS_MATCH;
		}

		return lottoMatchType;
	}
}
