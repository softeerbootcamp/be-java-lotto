package kr.codesquad.domain;

import kr.codesquad.enums.Rank2;

import java.util.List;

public class WinningLotto {
    private Lotto2 winningLotto;
    private int bonusBall;

    public WinningLotto() {
        bonusBall = 0;
    }
    public void setWinningNumbers(Lotto2 lotto) {
        winningLotto = lotto;
    }
    public void updateBonusBall(int bonusBall) {
        this.bonusBall = bonusBall;
    }
    public Rank2 compareLotto(Lotto2 lotto) {
        int count = winningLotto.match(lotto);
        boolean bonus = lotto.isContainsBonusBall(bonusBall);
        return Rank2.valueOf(count, bonus);
    }
}
