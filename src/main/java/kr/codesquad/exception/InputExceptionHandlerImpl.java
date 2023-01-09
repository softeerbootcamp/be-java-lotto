package kr.codesquad.exception;

import kr.codesquad.lotto.LottoNumber;

import java.io.IOException;

public class InputExceptionHandlerImpl implements InputExceptionHandler {
    @Override
    public IllegalArgumentException handleIOException(IOException e) {
        return new IllegalArgumentException("IOException");
    }

    @Override
    public IllegalArgumentException handleNumberFormatExceptionAndInputOutOfRangeException() {
        return new IllegalArgumentException("잘못된 형식의 입력입니다");
    }

    @Override
    public IllegalArgumentException handleLottoNumberOutOfRangeException(LottoNumberOutOfRangeException e) {
        return new IllegalArgumentException("로또 번호는 " + LottoNumber.MIN_NUMBER + " 부터 " + LottoNumber.MAX_NUMBER + "까지의 숫자만 입력할 수 있습니다");
    }
}
