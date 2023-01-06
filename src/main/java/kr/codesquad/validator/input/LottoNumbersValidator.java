package kr.codesquad.validator.input;

import kr.codesquad.model.lotto.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbersValidator {

    private static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "로또 번호는 " + Lotto.MINIMUM_NUMBER + "부터 " + Lotto.MAXIMUM_NUMBER + " 사이의 숫자여야 합니다.";
    private static final String LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE = "로또 번호는 서로 중복되지 않아야 합니다.";
    private static final String LOTTO_NUMBERS_SIZE_ERROR_MESSAGE = "로또 번호의 개수는 " + Lotto.NUMBERS_SIZE + "개여야 합니다.";

    public static void validate(List<Integer> numbers) {
        validateRange(numbers);
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private static void validateRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < Lotto.MINIMUM_NUMBER || number > Lotto.MAXIMUM_NUMBER)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != Lotto.NUMBERS_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE_ERROR_MESSAGE);
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        Set<Integer> numberStorage = new HashSet<>(numbers);
        if (numberStorage.size() != Lotto.NUMBERS_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }
}
