package kr.codesquad.domain;

import kr.codesquad.enums.Rank;

public class WinningLotto {
    private Lotto winningLotto;
    private int bonusBall;

    public WinningLotto(Lotto lotto, int bonusBall) {
        winningLotto = lotto;
        this.bonusBall = bonusBall;
    }

    public Rank compareLotto(Lotto lotto) {
        int count = winningLotto.match(lotto);
        boolean bonus = lotto.isContainsBonusBall(bonusBall);
        return Rank.valueOf(count, bonus);
    }
}
