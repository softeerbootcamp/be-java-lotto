package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

	private Lotto winningLotto;
	private int bonusBall;

	private WinningLotto(Lotto lotto, int bonusBall) {
		this.winningLotto = lotto;
		this.bonusBall = bonusBall;
	}

	public static WinningLotto of(Lotto lotto, int bonusBall) {
		return new WinningLotto(lotto, bonusBall);
	}

	public LottoMatchType matchLotto(Lotto lotto) {
		List<Integer> lottoNumbers = new ArrayList<>(lotto.getNumbers());
		lottoNumbers.removeAll(winningLotto.getNumbers()); // set으로 바꾸면 시간복잡도가 줄어듦

		LottoMatchType lottoMatchType = LottoMatchType.getLottoMatchTypeByMatchCount(
			winningLotto.getNumbersSize() - lottoNumbers.size());
		if (lotto.getNumbers().contains(bonusBall) && lottoMatchType == LottoMatchType.FIVE_MATCH) {
			return LottoMatchType.BONUS_MATCH;
		}

		return lottoMatchType;
	}
}
