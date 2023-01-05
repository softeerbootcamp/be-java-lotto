package kr.codesquad.validator;

import kr.codesquad.model.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public static class MoneyValidator {
        private static final String MONEY_INPUT_ERROR_MESSAGE = "금액은 " + Lotto.PRICE + " 단위로 입력해야 합니다.";

        public static void validate(int money) {
            if (money < Lotto.PRICE || money % Lotto.PRICE != 0) {
                throw new IllegalArgumentException(MONEY_INPUT_ERROR_MESSAGE);
            }
        }
    }

    public static class ManualLottoCountValidator {

        private static final String MANUAL_LOTTO_COUNT_INPUT_MINUS_ERROR_MESSAGE = "수동으로 구매할 로또 수는 0 이상을 입력해야 합니다.";
        private static final String MANUAL_LOTTO_COUNT_INPUT_OVER_ERROR_MESSAGE = "수동으로 구매할 로또 수는 총 구매한 로또 수보다 적어야 합니다.";

        public static void validate(int money, int count) {
            if (count < 0) {
                throw new IllegalArgumentException(MANUAL_LOTTO_COUNT_INPUT_MINUS_ERROR_MESSAGE);
            }

            int totalCount = money / Lotto.PRICE;
            if (totalCount < count) {
                throw new IllegalArgumentException(MANUAL_LOTTO_COUNT_INPUT_OVER_ERROR_MESSAGE);
            }
        }
    }

    public static class LottoNumbersValidator {

        private static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "로또 번호는 " + Lotto.MINIMUM_NUMBER + "부터 " + Lotto.MAXIMUM_NUMBER+ " 사이의 숫자여야 합니다.";
        private static final String LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE = "로또 번호는 서로 중복되지 않아야 합니다.";
        private static final String LOTTO_NUMBERS_SIZE_ERROR_MESSAGE = "로또 번호의 개수는 " + Lotto.NUMBERS_SIZE +"개여야 합니다.";

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

    public static class BonusNumberValidator {

        private static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "로또 번호는 " + Lotto.MINIMUM_NUMBER + "부터 " + Lotto.MAXIMUM_NUMBER+ " 사이의 숫자여야 합니다.";
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
}
