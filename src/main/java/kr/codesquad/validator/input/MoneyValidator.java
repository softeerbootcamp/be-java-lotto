package kr.codesquad.validator.input;

import kr.codesquad.model.lotto.Lotto;

public class MoneyValidator {
    private static final String MONEY_INPUT_ERROR_MESSAGE = "금액은 " + Lotto.PRICE + " 단위로 입력해야 합니다.";

    public static void validate(int money) {
        if (money < Lotto.PRICE || money % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(MONEY_INPUT_ERROR_MESSAGE);
        }
    }
}
