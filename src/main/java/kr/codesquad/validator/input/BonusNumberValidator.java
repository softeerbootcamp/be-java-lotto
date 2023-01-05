package kr.codesquad.validator.input;

import kr.codesquad.model.lotto.Lotto;

import java.util.List;

public class BonusNumberValidator {

    private static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "로또 번호는 " + Lotto.MINIMUM_NUMBER + "부터 " + Lotto.MAXIMUM_NUMBER + " 사이의 숫자여야 합니다.";
    private static final String BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE = "보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";

    public static void validate(List<Integer> numbers, int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplicationWithNumbers(numbers, bonusNumber);
    }

    private static void validateRange(int number) {
        if (number < Lotto.MINIMUM_NUMBER || number > Lotto.MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private static void validateDuplicationWithNumbers(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }
}
