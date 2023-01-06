package kr.codesquad.model.lotto;

import kr.codesquad.model.Rank;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank compare(Lotto otherLotto) {
        int sameCount = otherLotto.compare(lotto);
        boolean isBonus = otherLotto.contains(bonusNumber);

        return Rank.find(sameCount, isBonus);
    }
}
