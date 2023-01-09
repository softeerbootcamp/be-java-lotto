package kr.codesquad.domain.other;

import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.util.LottoUtil;

public class Bonus {

    public final int bonusNum;

    public Bonus(int bonusNum, Lotto lotto) {
        validateRange(bonusNum);
        validateDuplicate(bonusNum, lotto);
        this.bonusNum = bonusNum;
    }

    public int getBonusNum() {
        return bonusNum;
    }

    private void validateDuplicate(int bonusNum, Lotto lotto) {
        if(lotto.getNumberList().contains(bonusNum)) {
            throw new IllegalArgumentException("[error] 당첨 번호와 중복되는 보너스 번호입니다.");
        }
    }

    private void validateRange(int bonusNum) {
        if(bonusNum < LottoUtil.LOTTO_NUM_MIN_BOUND || bonusNum > LottoUtil.LOTTO_NUM_MAX_BOUND) {
            throw new IllegalArgumentException("[error] 입력할 수 없는 보너스 번호입니다.");
        }
    }
}
