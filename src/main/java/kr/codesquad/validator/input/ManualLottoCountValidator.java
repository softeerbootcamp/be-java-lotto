package kr.codesquad.validator.input;

import kr.codesquad.model.lotto.Lotto;

public class ManualLottoCountValidator {

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
