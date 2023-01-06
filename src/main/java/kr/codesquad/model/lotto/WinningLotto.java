package kr.codesquad.model.lotto;

import kr.codesquad.util.error.LottoErrorMessage;

import java.util.List;

public class WinningLotto extends ManualLotto {

    private final int bonusBall;

    public WinningLotto(List<Integer> winningNumbers, int bonusBall) {
        super(winningNumbers);
        this.bonusBall = bonusBall;
        validBonusBall();
    }

    public int getBonusBall() {
        return bonusBall;
    }

    private void validBonusBall() {
        if (numbers.contains(bonusBall)) {
            throw new IllegalArgumentException(LottoErrorMessage.DUPLICATE_BONUS_NUMBER);
        }
    }





}
