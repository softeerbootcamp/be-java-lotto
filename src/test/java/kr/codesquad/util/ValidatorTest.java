package kr.codesquad.util;

import kr.codesquad.domain.Money;
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
        assertThat(validator.checkLottoNumBoundary(1)).isEqualTo(true);
    }

    @Test
    void 숫자로_변환할_없는_문자입력() {
        Validator validator = new Validator();
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            validator.checkTransformabilityToNumber("문자입력");
        });
        assertEquals(ExceptionMessage.INVALID_NUM.getMessage(), exception.getMessage());
    }

    @Test
    void 입력한_문자로_숫자_변환() {
        Validator validator = new Validator();
        assertThat(validator.checkTransformabilityToNumber("231231")).isEqualTo(true);
    }

    @Test
    void null_체크() {
        Validator validator = new Validator();

        Throwable exception = assertThrows(RuntimeException.class, () -> {
            validator.checkNotNull("");
        });
        assertEquals(ExceptionMessage.CANNOT_INPUT_NULL.getMessage(), exception.getMessage());
    }

    @Test
    void null_아닐때_체크() {
        Validator validator = new Validator();
        assertThat(validator.checkNotNull("something")).isEqualTo(true);
    }

    @Test
    void 로또_번호_입력_테스트() {
        Validator validator = new Validator();
        assertThat(validator.checkLottoNumbers(new String[]{"1", "2", "3", "4", "5", "6"})).isEqualTo(true);
    }

    @Test
    void 로또_번호_입력_테스트_문자입력시() {
        Validator validator = new Validator();
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            validator.checkLottoNumbers(new String[]{"1", "2", "3", "4", "5", "ㅇㄹㅇㄹ"});
        });
        assertEquals(ExceptionMessage.INVALID_NUM.getMessage(), exception.getMessage());
    }

    @Test
    void 로또_번호_입력_테스트_공백입력시() {
        Validator validator = new Validator();
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            validator.checkLottoNumbers(new String[]{"1", "2", "3", "4", "5", ""});
        });
        assertEquals(ExceptionMessage.CANNOT_INPUT_NULL.getMessage(), exception.getMessage());
    }

    @Test
    void 로또_번호_입력_테스트_6개미만() {
        Validator validator = new Validator();
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            validator.checkLottoNumbers(new String[]{"1", "2", "3", "4"});
        });
        assertEquals(ExceptionMessage.INVALID_LOTTO_NUM_COUNT.getMessage(), exception.getMessage());
    }
    @Test
    void 구입금액_0원() {
        Validator validator = new Validator();
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            validator.checkMoneyBoundary("0");
        });
        assertEquals(ExceptionMessage.INVALID_MONEY_BOUNDARY.getMessage(), exception.getMessage());
    }
    @Test
    void 구입금액_1302원() {
        Validator validator = new Validator();
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            validator.checkMoneyBoundary("1302");
        });
        assertEquals(ExceptionMessage.INVALID_MONEY_COUNT.getMessage(), exception.getMessage());
    }
    @Test
    void 구입금액_1000원() {
        Validator validator = new Validator();
        assertThat(validator.checkMoneyBoundary("1000")).isEqualTo(true);
    }
    @Test
    void 구입금액_공백() {
        Validator validator = new Validator();
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            validator.checkMoneyBoundary("");
        });
        assertEquals(ExceptionMessage.CANNOT_INPUT_NULL.getMessage(), exception.getMessage());
    }
    @Test
    void 수동로또_개수_입력금액보다_클때() {
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            Validator.checkManualLottoCount("4", new Money(3000));
        });
        assertEquals(ExceptionMessage.CANNOT_BUY_OVER_MONEY.getMessage(), exception.getMessage());
    }
    @Test
    void 수동로또_개수_입력금액과_같을때() {
        assertThat(Validator.checkManualLottoCount("4", new Money(4000))).isEqualTo(true);
    }
    @Test
    void 수동로또_개수_입력금액보다_작을때() {
        assertThat(Validator.checkManualLottoCount("3", new Money(4000))).isEqualTo(true);
    }
}