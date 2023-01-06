package kr.codesquad;

import java.util.List;

public interface LottoCheck {

	public LottoResult checkLotto(List<Lotto> purchasedLottoList, WinningLotto winningLotto);

}
