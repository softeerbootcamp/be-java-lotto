package kr.codesquad.validator.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberValidatorTest {

    @Test
    @DisplayName("보너스 번호가 1~45 범위 밖의 숫자인 경우 예외가 발생한다.")
    void validateBonusNumberOfInvalidRange() {
        assertThatThrownBy(() -> BonusNumberValidator.validate(List.of(1, 2, 3, 4, 5, 6), 199))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복인 경우 예외가 발생한다.")
    void validateBonusNumberOfDuplicatedWithWinningNumbers() {
        assertThatThrownBy(() -> BonusNumberValidator.validate(List.of(1, 2, 3, 4, 5, 6), 199))
                .isInstanceOf(IllegalArgumentException.class);
    }

}