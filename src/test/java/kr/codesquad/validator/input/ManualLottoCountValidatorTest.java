package kr.codesquad.validator.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ManualLottoCountValidatorTest {

    @Test
    @DisplayName("수동 로또 구매 개수가 음수인 경우 예외가 발생한다.")
    void validateManualLottoCountOfMinusNumber() {
        assertThatThrownBy(() -> ManualLottoCountValidator.validate(-1, 1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수동 로또 구매 개수가 총 구매한 로또 개수를 초과한 경우 예외가 발생한다.")
    void validateManualLottoCountOverTotalLottoCount() {
        assertThatThrownBy(() -> ManualLottoCountValidator.validate(3, 2000))
                .isInstanceOf(IllegalArgumentException.class);
    }

}