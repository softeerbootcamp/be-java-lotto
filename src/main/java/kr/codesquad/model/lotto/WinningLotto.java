package kr.codesquad.model.lotto;

import java.util.List;

public class WinningLotto extends ManualLotto {

    private final int bonusBall;

    public WinningLotto(List<Integer> winningNumbers, int bonusBall) {
        super(winningNumbers);
        this.bonusBall = bonusBall;
    }

    public int getBonusBall() {
        return bonusBall;
    }




}
