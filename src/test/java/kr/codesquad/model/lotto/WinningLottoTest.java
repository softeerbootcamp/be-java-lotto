package kr.codesquad.model.lotto;

import kr.codesquad.util.error.LottoErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {
    @Test
    @DisplayName("보너스볼 중복숫자 예외 테스트")
    void duplicateBonus() {
        //given
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6);
        int duplicateBonusBall = input.get(0);
        //when,then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new WinningLotto(input,duplicateBonusBall));
        assertThat(e.getMessage()).isEqualTo(LottoErrorMessage.DUPLICATE_BONUS_NUMBER);
    }

}