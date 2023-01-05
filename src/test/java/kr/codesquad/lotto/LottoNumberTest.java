package kr.codesquad.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LottoNumber Test")
public class LottoNumberTest {

    @Test
    @DisplayName("new LottoNumber - 숫자가 1 ~ 45 사이의 범위에 존재하지 않는 경우")
    void testNewLottoNumberWhenIsInvalidNumberRange() {
        // given
        int invalidNumber = 0;

        // when
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> new LottoNumber(invalidNumber));

        // then
        assertEquals("로또 번호는 1 ~ 45 사이의 숫자만 입력 가능합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("equals - number 필드를 기준으로 비교 테스트")
    void testEquals() {
        // given
        LottoNumber one = new LottoNumber(1);
        LottoNumber two = new LottoNumber(1);

        // when
        boolean isEquals = one.equals(two);

        // then
        assertTrue(isEquals);
    }
}
