package kr.codesquad.model;

import java.util.List;

public class WinningLotto extends Lotto {

    private final int bonusBall;

    public WinningLotto(List<Integer> winningNumbers, int bonusBall) {
        this.bonusBall = bonusBall;
        this.numbers = winningNumbers;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
