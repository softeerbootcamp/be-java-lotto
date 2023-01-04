package kr.codesquad.lotto.check;

import kr.codesquad.lotto.LottoResult;
import kr.codesquad.lotto.LottoTicket;
import kr.codesquad.lotto.WinningLotto;

public interface LottoCheck {
    LottoResult check(LottoTicket lottoTicket, WinningLotto winningLotto);
}
