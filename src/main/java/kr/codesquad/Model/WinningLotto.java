package kr.codesquad.Model;

import kr.codesquad.Exception.InvalidLottoNumberException;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNo;

    public WinningLotto(Lotto lotto, int no) {
        this.bonusNo = LottoNumber.of(no);
        if (lotto.contains(bonusNo)) {
            throw new InvalidLottoNumberException("당첨번호랑 중복인데요?\n");
        }
        this.lotto = lotto;
    }

    public Rank match(Lotto userLotto) {
        int matchCount = lotto.match(userLotto);
        boolean matchBonus = userLotto.contains(bonusNo);
        return Rank.valueOf(matchCount, matchBonus);
    }
}
