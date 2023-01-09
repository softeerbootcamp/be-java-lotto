package kr.codesquad.exception;

import kr.codesquad.lotto.LottoNumber;

public class LottoNumberOutOfRangeException extends RuntimeException{
    public LottoNumberOutOfRangeException() {
        super(LottoNumber.MIN_NUMBER + "부터 " + LottoNumber.MAX_NUMBER + "까지의 숫자만 입력할 수 있습니다");
    }
}
