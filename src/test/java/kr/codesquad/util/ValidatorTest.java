package kr.codesquad.util;

import kr.codesquad.enums.ExceptionMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @Test
    void 로또_숫자_경계값_테스트_45이상() {
        Validator validator = new Validator();
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            validator.checkLottoNumBoundary(46);
        });
        assertEquals(ExceptionMessage.INVALID_LOTTO_NUM_BOUNDARY.getMessage(), exception.getMessage());
    }
    @Test
    void 로또_숫자_경계값_테스트_1이하() {
        Validator validator = new Validator();
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            validator.checkLottoNumBoundary(0);
        });
        assertEquals(ExceptionMessage.INVALID_LOTTO_NUM_BOUNDARY.getMessage(), exception.getMessage());
    }
    @Test
    void 로또_숫자_경계값_테스트_유효할때() {
        Validator validator = new Validator();
        assertThat(validator.checkLottoNumBoundary(1)).isEqualTo(1);
    }
    @Test
    void 숫자로_변환할_없는_문자입력() {
        Validator validator = new Validator();
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            validator.convertInputToNumber("문자입력");
        });
        assertEquals(ExceptionMessage.INVALID_NUM.getMessage(), exception.getMessage());
    }
    @Test
    void 입력한_문자로_숫자_변환() {
        Validator validator = new Validator();
        assertThat(validator.convertInputToNumber("231231")).isEqualTo(231231);
    }
}