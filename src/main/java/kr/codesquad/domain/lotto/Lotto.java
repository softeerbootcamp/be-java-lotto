package kr.codesquad.domain.lotto;

import kr.codesquad.domain.other.Bonus;
import kr.codesquad.domain.winLotto.WinLotto;
import kr.codesquad.util.LottoUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Lotto {

    private List<Integer> numberList;

    public Lotto(List<Integer> numberList) {
        validateInputLess(numberList);
        validateDuplicate(numberList);
        validateRange(numberList);
        this.numberList = numberList;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    private void validateInputLess(List<Integer> numberList) {
        if(numberList.size() < LottoUtil.LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("[error] 숫자 6자리를 입력해야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numberList) {
        if(numberList.stream().distinct().count() < LottoUtil.LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("[error] 중복된 숫자가 입력되었습니다.");
        }
    }

    private void validateRange(List<Integer> numberList) {
        numberList.stream()
                .filter(i -> i < LottoUtil.LOTTO_NUM_MIN_BOUND || i > LottoUtil.LOTTO_NUM_MAX_BOUND)
                .forEach(i -> {
            throw new IllegalArgumentException("[error] 입력할 수 없는 번호가 포함되어 있습니다. " + i);
        });
    }

    @Override
    public String toString() {
        return this.numberList.toString();
    }
}
