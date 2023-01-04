package kr.codesquad.domain;

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
}
