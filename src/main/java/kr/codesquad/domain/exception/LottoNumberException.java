package kr.codesquad.domain.exception;

import kr.codesquad.domain.LottoNumber;

import java.util.Objects;

public class LottoNumberException extends IllegalArgumentException {
    public static final String NOT_INTEGER_INPUT_EXCEPTION = "로또 인자로는 숫자만 가능합니다.";
    public static final String INVALID_RANGE_EXCEPTION = "유효한 범위 내의 로또 넘버가 아닙니다.";
    public LottoNumberException(int input) {
        super(input + "은 " +INVALID_RANGE_EXCEPTION);
    }

    public LottoNumberException(String input) {
        super(input + "이 들어왔습니다. " +NOT_INTEGER_INPUT_EXCEPTION);
    }
}
