package kr.codesquad.validator.input;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class LottoNumbersValidatorTest {

    @Test
    @DisplayName("로또 번호에 1~45 범위 이외의 숫자가 있으면 예외가 발생한다.")
    void validateLottoNumbersOfInvalidRange() {
        assertThatThrownBy(() -> LottoNumbersValidator.validate(List.of(1, 2, 3, 4, 5, 9999)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void validateLottoNumbersOfOverSize() {
        assertThatThrownBy(() -> LottoNumbersValidator.validate(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    void validateLottoNumbersOfUnderSize() {
        assertThatThrownBy(() -> LottoNumbersValidator.validate(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void validateLottoNumbersOfDuplication() {
        assertThatThrownBy(() -> LottoNumbersValidator.validate(List.of(1, 1, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}