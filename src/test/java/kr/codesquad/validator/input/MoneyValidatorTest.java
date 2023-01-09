package kr.codesquad.validator.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyValidatorTest {

    @Test
    @DisplayName("로또 구입 금액이 1,000 미만인 경우 예외가 발생한다.")
    void validateMoneyOfLessThanPrice() {
        assertThatThrownBy(() -> MoneyValidator.validate(-1))
                        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구입 금액이 1,000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    void validateMoneyOfInvalidUnitNumber() {
        assertThatThrownBy(() -> MoneyValidator.validate(100))
                .isInstanceOf(IllegalArgumentException.class);
    }

}